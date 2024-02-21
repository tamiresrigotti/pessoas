package com.attornatus.pessoas.enderecos.application.api.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.attornatus.pessoas.enderecos.application.api.repository.EnderecoRepository;
import com.attornatus.pessoas.enderecos.domain.Endereco;
import com.attornatus.pessoas.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {

	private final MongoTemplate mongoTemplate;
	private final EnderecoSpringMongoDBRepository enderecoSpringMongoDBRepository;
	
	@Override
	public Endereco postEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - postEndereco");
		enderecoSpringMongoDBRepository.save(endereco);
		log.info("[finaliza] EnderecoInfraRepository - postEndereco");
		return endereco;
	}

	@Override
	public Endereco exibeEnderecoPorId(UUID idEndereco) {
		log.info("[inicia] EnderecoInfraRepository - exibeEnderecoPorId");
		Endereco endereco = enderecoSpringMongoDBRepository.findById(idEndereco)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Endereço não encontrado!"));
		log.info("[finaliza] EnderecoInfraRepository - exibeEnderecoPorId");
		return endereco;
	}

	@Override
	public List<Endereco> listaEnderecoPorIdPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - listaEnderecoPorIdPessoa");
		List <Endereco> enderecos = enderecoSpringMongoDBRepository.findAllByIdPessoa(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - listaEnderecoPorIdPessoa");
		return enderecos;
	}

	public void defineTodosComoFalso(UUID idPessoa) {
        Query query = new Query(Criteria.where("idPessoa").is(idPessoa));
        Update update = Update.update("enderecoPrincipal", false);
        mongoTemplate.updateMulti(query, update, Endereco.class);
    }
}

package com.attornatus.pessoas.enderecos.application.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.attornatus.pessoas.enderecos.application.api.BuscaEnderecoPorIdResponse;
import com.attornatus.pessoas.enderecos.application.api.EnderecoRequest;
import com.attornatus.pessoas.enderecos.application.api.EnderecoResponse;
import com.attornatus.pessoas.enderecos.application.api.repository.EnderecoRepository;
import com.attornatus.pessoas.enderecos.domain.Endereco;
import com.attornatus.pessoas.pessoa.application.repository.PessoaRepository;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoResponse salvaEndereco(EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoService - salvaEndereco");
		log.info("[idPessoa] {}", enderecoRequest.getIdPessoa());
		pessoaRepository.buscaPessoaAtravesId(enderecoRequest.getIdPessoa());
		Endereco endereco = enderecoRepository.postEndereco(new Endereco(enderecoRequest));
		log.info("[finaliza] EnderecoService - salvaEndereco");
		return new EnderecoResponse(endereco);
	}

	@Override
	public BuscaEnderecoPorIdResponse getEnderecoPorId(UUID idEndereco) {
		log.info("[inicia] EnderecoService - salvaEndereco");
		Endereco endereco = enderecoRepository.exibeEnderecoPorId(idEndereco);
		log.info("[finaliza] EnderecoService - salvaEndereco");
		return new BuscaEnderecoPorIdResponse(endereco);
	}

	@Override
	public List<BuscaEnderecoPorIdResponse> getListaEndereco(UUID idPessoa) {
		log.info("[inicia] EnderecoService - getListaEndereco");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		List<Endereco> enderecos = enderecoRepository.listaEnderecoPorIdPessoa(pessoa.getIdPessoa());
		log.info("[finaliza] EnderecoService - getListaEndereco");
		return BuscaEnderecoPorIdResponse.converte(enderecos);
	}

	@Override
	public void definirEnderecoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoService - definirEnderecoPrincipal");
		pessoaRepository.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.exibeEnderecoPorId(idEndereco); 
		enderecoRepository.defineTodosComoFalso(idPessoa);
		endereco.definePrincipal();
		enderecoRepository.postEndereco(endereco);
		log.info("[finaliza] EnderecoService - definirEnderecoPrincipal");

	}

}

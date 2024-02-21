package com.attornatus.pessoas.enderecos.application.api.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attornatus.pessoas.enderecos.domain.Endereco;

public interface EnderecoSpringMongoDBRepository extends MongoRepository<Endereco, UUID> {

	List<Endereco> findAllByIdPessoa(UUID idPessoa);

}

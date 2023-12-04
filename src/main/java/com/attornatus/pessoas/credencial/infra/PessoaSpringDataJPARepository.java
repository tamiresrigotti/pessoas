package com.attornatus.pessoas.credencial.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.attornatus.pessoas.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends MongoRepository<Pessoa, UUID> {

}
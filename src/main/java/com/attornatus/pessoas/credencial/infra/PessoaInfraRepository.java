package com.attornatus.pessoas.credencial.infra;

import org.springframework.stereotype.Repository;

import com.attornatus.pessoas.credencial.application.repository.PessoaRepository;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2

public class PessoaInfraRepository implements PessoaRepository {

	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		log.info("[inicia] PessoaInfraRepository - salva");
		return pessoa;
	}

}

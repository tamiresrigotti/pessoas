package com.attornatus.pessoas.credencial.infra;

import org.springframework.stereotype.Repository;

import com.attornatus.pessoas.credencial.application.repository.PessoaRepository;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor

public class PessoaInfraRepository implements PessoaRepository {
	private final PessoaSpringDataJPARepository pessoaSprintDataJPARepository;
	
	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		pessoaSprintDataJPARepository.save(pessoa);
		log.info("[finaliza] PessoaInfraRepository - salva");
		return pessoa;
	}
}

package com.attornatus.pessoas.credencial.infra;

import java.util.List;

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

	@Override
	public List<Pessoa> buscaTodasPessoas() {
		log.info("[inicia] PessoaInfraRepository - buscaTodasPessoas");
		List<Pessoa> todasPessoas = pessoaSprintDataJPARepository.findAll();
		log.info("[finaliza] PessoaInfraRepository - buscaTodasPessoas");
		return todasPessoas;
	}
}

package com.attornatus.pessoas.credencial.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.attornatus.pessoas.credencial.application.repository.PessoaRepository;
import com.attornatus.pessoas.handler.APIException;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor

public class PessoaInfraRepository implements PessoaRepository {
	
	private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;
	
	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		pessoaSpringDataJPARepository.save(pessoa);
		log.info("[finaliza] PessoaInfraRepository - salva");
		return pessoa;
	}

	@Override
	public List<Pessoa> buscaTodasPessoas() {
		log.info("[inicia] PessoaInfraRepository - buscaTodasPessoas");
		List<Pessoa> todasPessoas = pessoaSpringDataJPARepository.findAll();
		log.info("[finaliza] PessoaInfraRepository - buscaTodasPessoas");
		return todasPessoas;
	}

	@Override
	public Pessoa buscaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaInfraRepository - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaSpringDataJPARepository.findById(idPessoa)
				.orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
		log.info("[finaliza] PessoaInfraRepository - buscaPessoaAtravesId");
		return pessoa;
	}

	@Override
	public void deletaPessoa(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - deletaPessoa");
		pessoaSpringDataJPARepository.delete(pessoa);
		log.info("[finaliza] PessoaInfraRepository - deletaPessoa");
	}
}

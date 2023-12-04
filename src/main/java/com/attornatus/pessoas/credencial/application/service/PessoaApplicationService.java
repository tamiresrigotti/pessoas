package com.attornatus.pessoas.credencial.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;
import com.attornatus.pessoas.credencial.application.api.PessoaRequest;
import com.attornatus.pessoas.credencial.application.api.PessoaResponse;
import com.attornatus.pessoas.credencial.application.repository.PessoaRepository;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor

public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder()
				.idPessoa(pessoa.getIdPessoa())
				.build();
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return null;
	}

}

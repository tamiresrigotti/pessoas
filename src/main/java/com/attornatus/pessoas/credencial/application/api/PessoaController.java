package com.attornatus.pessoas.credencial.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.attornatus.pessoas.credencial.application.service.PessoaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor

public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}

	@Override
	public PessoaDetalhadaResponse getPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		log.info("[finaliza] PessoaController - getPessoaAtravesId");
		return null;
	}

}

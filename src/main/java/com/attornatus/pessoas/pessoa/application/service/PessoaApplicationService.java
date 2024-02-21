package com.attornatus.pessoas.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.attornatus.pessoas.pessoa.application.api.PessoaAlteracaoRequest;
import com.attornatus.pessoas.pessoa.application.api.PessoaDetalhadaResponse;
import com.attornatus.pessoas.pessoa.application.api.PessoaListResponse;
import com.attornatus.pessoas.pessoa.application.api.PessoaRequest;
import com.attornatus.pessoas.pessoa.application.api.PessoaResponse;
import com.attornatus.pessoas.pessoa.application.repository.PessoaRepository;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return PessoaListResponse.converte(pessoas);
	}

	@Override
	public PessoaDetalhadaResponse buscaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
		return new PessoaDetalhadaResponse(pessoa);
	}

	@Override
	public void deletaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - deletaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		pessoaRepository.deletaPessoa(pessoa);
		log.info("[finaliza] PessoaApplicationService - deletaPessoaAtravesId");
	}

	@Override
	public void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaApplicationService - patchAlteraPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		pessoa.altera(pessoaAlteracaoRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - patchAlteraPessoa");
	}

}
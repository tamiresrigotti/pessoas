package com.attornatus.pessoas.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import com.attornatus.pessoas.pessoa.application.api.PessoaAlteracaoRequest;
import com.attornatus.pessoas.pessoa.application.api.PessoaDetalhadaResponse;
import com.attornatus.pessoas.pessoa.application.api.PessoaListResponse;
import com.attornatus.pessoas.pessoa.application.api.PessoaRequest;
import com.attornatus.pessoas.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
	PessoaDetalhadaResponse buscaPessoaAtravesId(UUID idPessoa);
	void deletaPessoaAtravesId(UUID idPessoa);
	void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);
		
}
 
package com.attornatus.pessoas.credencial.application.service;

import java.util.List;

import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;
import com.attornatus.pessoas.credencial.application.api.PessoaRequest;
import com.attornatus.pessoas.credencial.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);

	List<PessoaListResponse> buscaTodasPessoas();
}

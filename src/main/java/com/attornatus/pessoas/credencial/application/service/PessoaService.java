package com.attornatus.pessoas.credencial.application.service;

import com.attornatus.pessoas.credencial.application.api.PessoaRequest;
import com.attornatus.pessoas.credencial.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
}

package com.attornatus.pessoas.credencial.application.service;

import java.util.List;
import java.util.UUID;

import com.attornatus.pessoas.credencial.application.api.PessoaDetalhadaResponse;
import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;
import com.attornatus.pessoas.credencial.application.api.PessoaRequest;
import com.attornatus.pessoas.credencial.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
	PessoaDetalhadaResponse buscaPessoaAtravesId(UUID idPessoa);
	void deletaPessoaAtravesId(UUID idPessoa);
}
 
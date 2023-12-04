package com.attornatus.pessoas.credencial.application.repository;

import java.util.List;

import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodasPessoas();
}

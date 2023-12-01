package com.attornatus.pessoas.credencial.application.repository;

import com.attornatus.pessoas.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
}

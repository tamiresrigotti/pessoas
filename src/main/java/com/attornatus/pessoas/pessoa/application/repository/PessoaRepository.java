package com.attornatus.pessoas.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import com.attornatus.pessoas.pessoa.domain.Pessoa;

public interface PessoaRepository{
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodasPessoas();
	Pessoa buscaPessoaAtravesId (UUID idPessoa);
	void deletaPessoa(Pessoa pessoa);
	
	}
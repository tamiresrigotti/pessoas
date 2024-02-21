package com.attornatus.pessoas.enderecos.application.api.repository;

import java.util.List;
import java.util.UUID;

import com.attornatus.pessoas.enderecos.domain.Endereco;

public interface EnderecoRepository {

	Endereco postEndereco(Endereco endereco);

	Endereco exibeEnderecoPorId(UUID idEndereco);

	List<Endereco> listaEnderecoPorIdPessoa(UUID idPessoa);

	void defineTodosComoFalso(UUID idPessoa);
}

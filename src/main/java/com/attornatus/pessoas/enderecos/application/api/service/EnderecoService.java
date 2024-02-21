package com.attornatus.pessoas.enderecos.application.api.service;

import java.util.List;
import java.util.UUID;

import com.attornatus.pessoas.enderecos.application.api.BuscaEnderecoPorIdResponse;
import com.attornatus.pessoas.enderecos.application.api.EnderecoRequest;
import com.attornatus.pessoas.enderecos.application.api.EnderecoResponse;

public interface EnderecoService {

	EnderecoResponse salvaEndereco(EnderecoRequest enderecoRequest);

	BuscaEnderecoPorIdResponse getEnderecoPorId(UUID idEndereco);

	List<BuscaEnderecoPorIdResponse> getListaEndereco(UUID idPessoa);

	void definirEnderecoPrincipal(UUID idPessoa, UUID idEndereco);
}

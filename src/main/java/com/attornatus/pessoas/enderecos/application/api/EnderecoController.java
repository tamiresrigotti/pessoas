package com.attornatus.pessoas.enderecos.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import com.attornatus.pessoas.enderecos.application.api.service.EnderecoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse postEndereco(@Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", enderecoRequest.getIdPessoa());
		EnderecoResponse endereco = enderecoService.salvaEndereco(enderecoRequest);
		log.info("[finaliza] EnderecoController - postEndereco");
		return endereco;
	}

	@Override
	public BuscaEnderecoPorIdResponse buscaEnderecoPorId(UUID idEndereco) {
		log.info("[inicia] EnderecoController - buscaEnderecoPorId");
		log.info("[idPessoa] {}",idEndereco);
		BuscaEnderecoPorIdResponse buscaEnderecoPorIdResponse = enderecoService.getEnderecoPorId(idEndereco);
		log.info("[finaliza] EnderecoController - buscaEnderecoPorId");
		return buscaEnderecoPorIdResponse;
	}

	@Override
	public List<BuscaEnderecoPorIdResponse> listaEnderecoPorIdPessoa(UUID idPessoa) {
		log.info("[idPessoa] {}",idPessoa);
		List<BuscaEnderecoPorIdResponse> listaEndereco = enderecoService.getListaEndereco(idPessoa);
		log.info("[finaliza] EnderecoController - listaEnderecoPorIdPessoa");
		return listaEndereco;
		
	}

	@Override
	public void definirComoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - definirComoPrincipal");
		enderecoService.definirEnderecoPrincipal(idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - definirComoPrincipal");
		
	}

}

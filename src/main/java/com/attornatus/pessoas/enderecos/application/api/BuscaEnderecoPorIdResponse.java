package com.attornatus.pessoas.enderecos.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.attornatus.pessoas.enderecos.domain.Endereco;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuscaEnderecoPorIdResponse {
	private UUID idEndereco;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Boolean enderecoPrincipal;

	public BuscaEnderecoPorIdResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.enderecoPrincipal = endereco.getEnderecoPrincipal();
	}

	public static List<BuscaEnderecoPorIdResponse> converte(List<Endereco> enderecos) {
		return enderecos.stream().map(BuscaEnderecoPorIdResponse::new).collect(Collectors.toList());
	}
}

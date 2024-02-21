package com.attornatus.pessoas.enderecos.application.api;

import java.util.UUID;

import com.attornatus.pessoas.enderecos.domain.Endereco;

import lombok.Value;

@Value
public class EnderecoResponse {

	private UUID idEndereco;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public EnderecoResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
	}
}

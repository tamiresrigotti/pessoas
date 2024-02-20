package com.attornatus.pessoas.pessoa.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.attornatus.pessoas.pessoa.domain.Endereco;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoRequest {

	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String cep;
	
	public EnderecoRequest(Endereco endereco) {

		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
	}
}

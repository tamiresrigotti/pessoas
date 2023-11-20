package com.attornatus.pessoas.pessoa.domain;

import javax.validation.constraints.NotBlank;


public class Endereco {
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String cep;

	public Endereco(@NotBlank String rua, @NotBlank String numero, @NotBlank String cidade, @NotBlank String estado,
			@NotBlank String cep) {

		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

}

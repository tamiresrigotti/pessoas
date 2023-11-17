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
}

package com.attornatus.pessoas.pessoa.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
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
	@NotNull
	public Endereco(@NotBlank String rua, @NotBlank String numero, @NotBlank String bairro, @NotBlank String cidade,
			@NotBlank String estado, @NotBlank String cep) {

		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
}

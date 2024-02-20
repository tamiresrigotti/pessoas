package com.attornatus.pessoas.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaRequest {

	@NotBlank
	private String nomeCompleto;

	private String cpf;

	@NotNull
	private LocalDate dataDeNascimento;

}


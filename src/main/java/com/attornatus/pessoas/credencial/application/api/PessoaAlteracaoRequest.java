package com.attornatus.pessoas.credencial.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.attornatus.pessoas.pessoa.domain.Endereco;

import lombok.Value;

@Value
public class PessoaAlteracaoRequest {

	@NotBlank
	private String nomeCompleto;

	@NotNull
	private LocalDate dataDeNascimento;

	@NotNull
	private Endereco endereco;

}

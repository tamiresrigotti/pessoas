package com.attornatus.pessoas.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.attornatus.pessoas.pessoa.domain.Endereco;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaAlteracaoRequest {

	@NotBlank
	private String nomeCompleto;

	@NotNull
	private LocalDate dataDeNascimento;

	@NotNull
	private EnderecoRequest enderecoPrincipal;

}

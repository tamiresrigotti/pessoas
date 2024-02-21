package com.attornatus.pessoas.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.attornatus.pessoas.pessoa.application.api.PessoaAlteracaoRequest;
import com.attornatus.pessoas.pessoa.application.api.PessoaRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "pessoas")
public class Pessoa {

	@Id
	private UUID idPessoa;

	@NotBlank
	private String nomeCompleto;

	@CPF
	@Indexed(unique = true)
	private String cpf;

	@NotNull
	private LocalDate dataDeNascimento;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoradaUltimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.cpf = pessoaRequest.getCpf();
		this.dataDeNascimento = pessoaRequest.getDataDeNascimento();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nomeCompleto = pessoaAlteracaoRequest.getNomeCompleto();
		this.dataDeNascimento = pessoaAlteracaoRequest.getDataDeNascimento();
		this.dataHoradaUltimaAlteracao = LocalDateTime.now();
	}

}

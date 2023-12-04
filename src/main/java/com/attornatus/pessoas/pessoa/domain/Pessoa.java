package com.attornatus.pessoas.pessoa.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.attornatus.pessoas.credencial.application.api.PessoaRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
public class Pessoa {

    @Id
    private UUID idPessoa;

    @NotBlank
    private String nomeCompleto;

    @NotNull
    private LocalDate dataDeNascimento;

    @NotNull
    private Endereco endereco;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoradaUltimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataDeNascimento = pessoaRequest.getDataDeNascimento();
		this.endereco = pessoaRequest.getEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}
}

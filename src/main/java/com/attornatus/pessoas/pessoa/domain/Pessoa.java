package com.attornatus.pessoas.pessoa.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;

    @NotBlank
    private String nomeCompleto;

    @NotNull
    private LocalDate dataDeNascimento;

    @NotNull
    private Endereco endereco;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoradaUltimaAlteracao;

	public Pessoa(@NotBlank String nomeCompleto, @NotBlank LocalDate dataDeNascimento, @NotBlank Endereco endereco) {
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.dataHoraDoCadastro = LocalDateTime.now();
	}
}

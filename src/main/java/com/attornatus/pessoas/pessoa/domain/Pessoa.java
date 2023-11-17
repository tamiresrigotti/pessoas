package com.attornatus.pessoas.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {
	@Id
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private LocalDate dataDeNascimento;
	@NotBlank
	private Endereco endereco;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoradaUltimaAlteracao;

	public Pessoa(@NotBlank String nomeCompleto, @NotBlank LocalDate dataDeNascimento, @NotBlank Endereco endereco) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.dataHoraDoCadastro = LocalDateTime.now();    
	}
}

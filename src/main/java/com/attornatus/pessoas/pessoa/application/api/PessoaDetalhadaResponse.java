package com.attornatus.pessoas.pessoa.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.attornatus.pessoas.pessoa.domain.Endereco;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaDetalhadaResponse {

	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataDeNascimento;
	private LocalDateTime dataHoraDoCadastro;
	
	public PessoaDetalhadaResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataDeNascimento = pessoa.getDataDeNascimento();
		this.dataHoraDoCadastro = pessoa.getDataHoraDoCadastro();
	}
}

package com.attornatus.pessoas.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.attornatus.pessoas.enderecos.domain.Endereco;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

import lombok.Value;

@Value
public class PessoaListResponse {

	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataDeNascimento;
	public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(PessoaListResponse::new)
				.collect(Collectors.toList());
	}

	private PessoaListResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataDeNascimento = pessoa.getDataDeNascimento();
		}
}

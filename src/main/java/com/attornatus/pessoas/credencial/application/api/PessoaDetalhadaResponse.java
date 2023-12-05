package com.attornatus.pessoas.credencial.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.attornatus.pessoas.pessoa.domain.Endereco;

public class PessoaDetalhadaResponse {

	    private UUID idPessoa;
	    private String nomeCompleto;
	    private LocalDate dataDeNascimento;
	    private Endereco endereco;
	    private LocalDateTime dataHoraDoCadastro;
}

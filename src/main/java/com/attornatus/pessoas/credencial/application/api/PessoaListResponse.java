package com.attornatus.pessoas.credencial.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.attornatus.pessoas.pessoa.domain.Endereco;
import com.attornatus.pessoas.pessoa.domain.Pessoa;

public class PessoaListResponse {

    private UUID idPessoa;
    private String nomeCompleto;
    private LocalDate dataDeNascimento;
    private Endereco endereco;
    
public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
		// TODO Auto-generated method stub
		return null;
	}
}

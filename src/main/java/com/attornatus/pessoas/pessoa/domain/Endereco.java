package com.attornatus.pessoas.pessoa.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.attornatus.pessoas.pessoa.application.api.EnderecoRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {

	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco(EnderecoRequest enderecoRequest) {
		
		this.rua = enderecoRequest.getRua();
		this.numero =  enderecoRequest.getNumero();
		this.bairro =  enderecoRequest.getBairro();
		this.cidade =  enderecoRequest.getCidade();
		this.estado =  enderecoRequest.getEstado();
		this.cep =  enderecoRequest.getCep();
	}

}
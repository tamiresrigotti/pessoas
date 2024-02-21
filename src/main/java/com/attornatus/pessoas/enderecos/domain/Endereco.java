package com.attornatus.pessoas.enderecos.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.attornatus.pessoas.enderecos.application.api.EnderecoRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "enderecos")
public class Endereco {
	@Id
	private UUID idEndereco;
	@Indexed
	private UUID idPessoa;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Boolean enderecoPrincipal;

	public Endereco(EnderecoRequest enderecoRequest) {
		this.idPessoa = enderecoRequest.getIdPessoa();
		this.idEndereco = UUID.randomUUID();
		this.rua = enderecoRequest.getRua();
		this.numero = enderecoRequest.getNumero();
		this.bairro = enderecoRequest.getBairro();
		this.cidade = enderecoRequest.getCidade();
		this.estado = enderecoRequest.getEstado();
		this.cep = enderecoRequest.getCep();
	}

	public void definePrincipal() {
		this.enderecoPrincipal = true;
	}

}
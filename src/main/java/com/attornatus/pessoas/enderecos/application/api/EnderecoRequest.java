package com.attornatus.pessoas.enderecos.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.attornatus.pessoas.enderecos.domain.Endereco;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoRequest {
	@NotNull
	private UUID idPessoa;
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String cep;

	public EnderecoRequest(Endereco endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
	}
}

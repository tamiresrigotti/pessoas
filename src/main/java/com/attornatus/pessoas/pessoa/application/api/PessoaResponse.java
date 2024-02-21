package com.attornatus.pessoas.pessoa.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PessoaResponse {
	private UUID idPessoa; 

}

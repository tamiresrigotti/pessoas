package com.attornatus.pessoas.pessoa.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface EnderecoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse postEndereco(@Valid @RequestBody EnderecoRequest enderecoRequest);
	
	
}

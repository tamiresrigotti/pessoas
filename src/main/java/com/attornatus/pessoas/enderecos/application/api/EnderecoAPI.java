package com.attornatus.pessoas.enderecos.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/endereco")
public interface EnderecoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse postEndereco(@Valid @RequestBody EnderecoRequest enderecoRequest);

	@GetMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.OK)
	BuscaEnderecoPorIdResponse buscaEnderecoPorId(@PathVariable UUID idEndereco);

	@GetMapping(value = "/{idPessoa}/lista")
	@ResponseStatus(code = HttpStatus.OK)
	List<BuscaEnderecoPorIdResponse> listaEnderecoPorIdPessoa(@PathVariable UUID idPessoa);


	@PatchMapping(value = "/{idPessoa}/endprincipal")
	@ResponseStatus(code = HttpStatus.OK)
	void definirComoPrincipal(@PathVariable UUID idPessoa, @RequestParam UUID idEndereco);

}

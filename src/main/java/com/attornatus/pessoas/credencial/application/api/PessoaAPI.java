package com.attornatus.pessoas.credencial.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse postPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<PessoaListResponse> getTodasPessoas();

	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	PessoaDetalhadaResponse getPessoaAtravesId(@PathVariable UUID idPessoa);

	@DeleteMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaPessoaAtravesId(@PathVariable UUID idPessoa);
	
	@PatchMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraPessoa(@PathVariable UUID idPessoa,
			@Valid @RequestBody PessoaAlteracaoRequest pessoaAlteracaoRequest);

}

package com.attornatus.pessoas.pessoa.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.attornatus.pessoas.credencial.application.api.PessoaRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "pessoas")
public class Pessoa {

    @Id
    private UUID idPessoa;

    @NotBlank
    private String nomeCompleto;
    
    @NotBlank
    @CPF
    @Indexed(unique = true)
    private String cpf;

    @NotNull
    private LocalDate dataDeNascimento;

    @NotNull
    @Valid
    private Endereco endereco;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoradaUltimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.cpf = pessoaRequest.getCpf();
		this.dataDeNascimento = pessoaRequest.getDataDeNascimento();
		this.endereco = pessoaRequest.getEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}
}

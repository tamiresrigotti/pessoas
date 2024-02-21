[1mdiff --git a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAPI.java b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAPI.java[m
[1mindex b413ece..c7e032a 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAPI.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAPI.java[m
[36m@@ -36,7 +36,7 @@[m [mpublic interface PessoaAPI {[m
 	void deletaPessoaAtravesId(@PathVariable UUID idPessoa);[m
 	[m
 	@PatchMapping(value = "/{idPessoa}")[m
[31m-	@ResponseStatus(code = HttpStatus.CREATED)[m
[32m+[m	[32m@ResponseStatus(code = HttpStatus.NO_CONTENT)[m
 	void patchAlteraPessoa(@PathVariable UUID idPessoa,[m
 			@Valid @RequestBody PessoaAlteracaoRequest pessoaAlteracaoRequest);[m
 [m
[1mdiff --git a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAlteracaoRequest.java b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAlteracaoRequest.java[m
[1mindex ac6f40e..909a6d9 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAlteracaoRequest.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaAlteracaoRequest.java[m
[36m@@ -5,8 +5,6 @@[m [mimport java.time.LocalDate;[m
 import javax.validation.constraints.NotBlank;[m
 import javax.validation.constraints.NotNull;[m
 [m
[31m-import org.hibernate.validator.constraints.br.CPF;[m
[31m-[m
 import com.attornatus.pessoas.pessoa.domain.Endereco;[m
 [m
 import lombok.Value;[m
[1mdiff --git a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaController.java b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaController.java[m
[1mindex 1aa2f71..ade1109 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaController.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/credencial/application/api/PessoaController.java[m
[36m@@ -56,6 +56,7 @@[m [mpublic class PessoaController implements PessoaAPI {[m
 	public void patchAlteraPessoa(UUID idPessoa, @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {[m
 		log.info("[inicia] PessoaController - patchAlteraPessoa");[m
 		log.info("[idPessoa] {}", idPessoa);[m
[32m+[m		[32mpessoaService.patchAlteraPessoa(idPessoa, pessoaAlteracaoRequest);[m
 		log.info("[finaliza] PessoaController - patchAlteraPessoa");[m
 		[m
 	}[m
[1mdiff --git a/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaApplicationService.java b/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaApplicationService.java[m
[1mindex 3cc7bef..77ae962 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaApplicationService.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaApplicationService.java[m
[36m@@ -5,6 +5,7 @@[m [mimport java.util.UUID;[m
 [m
 import org.springframework.stereotype.Service;[m
 [m
[32m+[m[32mimport com.attornatus.pessoas.credencial.application.api.PessoaAlteracaoRequest;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaDetalhadaResponse;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaRequest;[m
[36m@@ -54,4 +55,14 @@[m [mpublic class PessoaApplicationService implements PessoaService {[m
 		log.info("[finaliza] PessoaApplicationService - deletaPessoaAtravesId");[m
 	}[m
 [m
[32m+[m	[32m@Override[m
[32m+[m	[32mpublic void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest) {[m
[32m+[m		[32mlog.info("[inicia] PessoaApplicationService - patchAlteraPessoa");[m
[32m+[m		[32mPessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);[m
[32m+[m		[32mpessoa.altera(pessoaAlteracaoRequest);[m
[32m+[m		[32mpessoaRepository.salva(pessoa);[m
[32m+[m		[32mlog.info("[finaliza] PessoaApplicationService - patchAlteraPessoa");[m
[32m+[m[41m		[m
[32m+[m	[32m}[m
[32m+[m
 }[m
[1mdiff --git a/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaService.java b/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaService.java[m
[1mindex a37a082..a57bb16 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaService.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/credencial/application/service/PessoaService.java[m
[36m@@ -3,6 +3,7 @@[m [mpackage com.attornatus.pessoas.credencial.application.service;[m
 import java.util.List;[m
 import java.util.UUID;[m
 [m
[32m+[m[32mimport com.attornatus.pessoas.credencial.application.api.PessoaAlteracaoRequest;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaDetalhadaResponse;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaListResponse;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaRequest;[m
[36m@@ -13,5 +14,6 @@[m [mpublic interface PessoaService {[m
 	List<PessoaListResponse> buscaTodasPessoas();[m
 	PessoaDetalhadaResponse buscaPessoaAtravesId(UUID idPessoa);[m
 	void deletaPessoaAtravesId(UUID idPessoa);[m
[32m+[m	[32mvoid patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);[m
 }[m
  [m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/attornatus/pessoas/pessoa/domain/Pessoa.java b/src/main/java/com/attornatus/pessoas/pessoa/domain/Pessoa.java[m
[1mindex ef9c7a9..3cfc638 100644[m
[1m--- a/src/main/java/com/attornatus/pessoas/pessoa/domain/Pessoa.java[m
[1m+++ b/src/main/java/com/attornatus/pessoas/pessoa/domain/Pessoa.java[m
[36m@@ -1,4 +1,5 @@[m
 package com.attornatus.pessoas.pessoa.domain;[m
[32m+[m
 import java.time.LocalDate;[m
 import java.time.LocalDateTime;[m
 import java.util.UUID;[m
[36m@@ -12,6 +13,7 @@[m [mimport org.springframework.data.annotation.Id;[m
 import org.springframework.data.mongodb.core.index.Indexed;[m
 import org.springframework.data.mongodb.core.mapping.Document;[m
 [m
[32m+[m[32mimport com.attornatus.pessoas.credencial.application.api.PessoaAlteracaoRequest;[m
 import com.attornatus.pessoas.credencial.application.api.PessoaRequest;[m
 [m
 import lombok.AccessLevel;[m
[36m@@ -23,26 +25,26 @@[m [mimport lombok.NoArgsConstructor;[m
 @Document(collection = "pessoas")[m
 public class Pessoa {[m
 [m
[31m-    @Id[m
[31m-    private UUID idPessoa;[m
[32m+[m	[32m@Id[m
[32m+[m	[32mprivate UUID idPessoa;[m
[32m+[m
[32m+[m	[32m@NotBlank[m
[32m+[m	[32mprivate String nomeCompleto;[m
 [m
[31m-    @NotBlank[m
[31m-    private String nomeCompleto;[m
[31m-    [m
[31m-    @NotBlank[m
[31m-    @CPF[m
[31m-    @Indexed(unique = true)[m
[31m-    private String cpf;[m
[32m+[m	[32m@NotBlank[m
[32m+[m	[32m@CPF[m
[32m+[m	[32m@Indexed(unique = true)[m
[32m+[m	[32mprivate String cpf;[m
 [m
[31m-    @NotNull[m
[31m-    private LocalDate dataDeNascimento;[m
[32m+[m	[32m@NotNull[m
[32m+[m	[32mprivate LocalDate dataDeNascimento;[m
 [m
[31m-    @NotNull[m
[31m-    @Valid[m
[31m-    private Endereco endereco;[m
[32m+[m	[32m@NotNull[m
[32m+[m	[32m@Valid[m
[32m+[m	[32mprivate Endereco endereco;[m
 [m
[31m-    private LocalDateTime dataHoraDoCadastro;[m
[31m-    private LocalDateTime dataHoradaUltimaAlteracao;[m
[32m+[m	[32mprivate LocalDateTime dataHoraDoCadastro;[m
[32m+[m	[32mprivate LocalDateTime dataHoradaUltimaAlteracao;[m
 [m
 	public Pessoa(PessoaRequest pessoaRequest) {[m
 		this.idPessoa = UUID.randomUUID();[m
[36m@@ -52,4 +54,13 @@[m [mpublic class Pessoa {[m
 		this.endereco = pessoaRequest.getEndereco();[m
 		this.dataHoraDoCadastro = LocalDateTime.now();[m
 	}[m
[32m+[m
[32m+[m	[32mpublic void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {[m
[32m+[m		[32mthis.idPessoa = UUID.randomUUID();[m
[32m+[m		[32mthis.nomeCompleto = pessoaAlteracaoRequest.getNomeCompleto();[m
[32m+[m		[32mthis.dataDeNascimento = pessoaAlteracaoRequest.getDataDeNascimento();[m
[32m+[m		[32mthis.endereco = pessoaAlteracaoRequest.getEndereco();[m
[32m+[m		[32mthis.dataHoradaUltimaAlteracao = LocalDateTime.now();[m
[32m+[m	[32m}[m
[32m+[m
 }[m

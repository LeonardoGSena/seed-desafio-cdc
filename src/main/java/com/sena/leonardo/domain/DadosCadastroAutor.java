package com.sena.leonardo.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DadosCadastroAutor(
    @NotBlank(message = "Nome é obrigatório")
    String nome,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de email inválido")
    String email,

    @NotBlank(message = "Descrição é obrigatório")
    @Size(max = 400)
    String descricao
) {

}

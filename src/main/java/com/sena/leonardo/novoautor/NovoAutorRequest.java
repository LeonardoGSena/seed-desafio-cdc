package com.sena.leonardo.novoautor;

import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NovoAutorRequest implements DadosNovoAutor{

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}

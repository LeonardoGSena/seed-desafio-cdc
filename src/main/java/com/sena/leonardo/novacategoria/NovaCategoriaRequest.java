package com.sena.leonardo.novacategoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @JsonCreator
    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

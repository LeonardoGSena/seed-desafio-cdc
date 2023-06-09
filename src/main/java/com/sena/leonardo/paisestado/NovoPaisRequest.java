package com.sena.leonardo.paisestado;

import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class NovoPaisRequest implements DadosNovoPais{

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Pais toModel() {
        return new Pais(this.nome);
    }
}

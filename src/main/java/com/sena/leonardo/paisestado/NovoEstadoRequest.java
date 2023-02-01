package com.sena.leonardo.paisestado;

import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public NovoEstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "NovoEstadoRequest{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }

    public Estado toModel(EntityManager manager) {
        return new Estado(nome, manager.find(Pais.class, idPais));
    }
}

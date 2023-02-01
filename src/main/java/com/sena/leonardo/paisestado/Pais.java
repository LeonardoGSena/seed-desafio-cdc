package com.sena.leonardo.paisestado;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        return nome != null ? nome.equals(pais.nome) : pais.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}

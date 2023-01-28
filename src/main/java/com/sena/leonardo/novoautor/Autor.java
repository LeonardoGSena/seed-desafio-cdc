package com.sena.leonardo.novoautor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;
    private LocalDateTime instanciaCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Não é possivel criar autores nem nome");
        }
        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Não é possivel criar autores nem email");
        }
        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Não é possivel criar autores nem descrição");
        }
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instanciaCriacao=" + instanciaCriacao +
                '}';
    }
}

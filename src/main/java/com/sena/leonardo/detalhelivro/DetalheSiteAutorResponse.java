package com.sena.leonardo.detalhelivro;

import com.sena.leonardo.novoautor.Autor;

public class DetalheSiteAutorResponse {

    private String nome;
    private String descricao;

    public DetalheSiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

package com.sena.leonardo.domain;

import java.time.LocalDateTime;

public record DadosDetalhamentoAuto(Long id, String nome, String email, String descricao, LocalDateTime instante) {
    public DadosDetalhamentoAuto (Autor autor){
        this(autor.getId(), autor.getNome(), autor.getEmail(), autor.getDescricao(), autor.getInstanteCriacao());
    }
}

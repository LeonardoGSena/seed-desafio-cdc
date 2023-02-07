package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.novolivro.Livro;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class NovoPedidotItemRequest {

    @NotNull
    @ExistsId(domainClass = Livro.class,fieldName = "id")
    private Long idLivro;
    @Positive
    private int quantidade;

    public NovoPedidotItemRequest(Long idLivro, int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "NovoPedidotItemRequest{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public ItemPedido toModel(EntityManager manager) {
        @NotNull Livro livro = manager.find(Livro.class, idLivro);
        return new ItemPedido(livro, quantidade);
    }
}

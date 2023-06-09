package com.sena.leonardo.novolivro;

import com.sena.leonardo.novacategoria.Categoria;
import com.sena.leonardo.novoautor.Autor;

import java.util.function.Function;

public interface DadosNovoLivro {

    public Livro toModel(Function<Long, Autor> carregaAutor, Function<Long, Categoria> carregaCategoria);
}

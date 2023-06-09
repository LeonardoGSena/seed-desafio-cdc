package com.sena.leonardo.novolivro;

import com.sena.leonardo.novacategoria.Categoria;
import com.sena.leonardo.novoautor.Autor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroNovoLivro {

    private final LivroRepository livroRepository;
    private final BuscadorDeEntidades buscadorDeEntidades;

    public CadastroNovoLivro(LivroRepository livroRepository, BuscadorDeEntidades buscadorDeEntidades) {
        this.livroRepository = livroRepository;
        this.buscadorDeEntidades = buscadorDeEntidades;
    }


    @Transactional
    public Livro cadastraLivro(@Valid DadosNovoLivro dados) {
        Livro novoLivro = dados.toModel(
                idAutor -> buscadorDeEntidades.buscaPorId(Autor.class, idAutor),
                idCategoria -> buscadorDeEntidades.buscaPorId(Categoria.class, idCategoria));
        return livroRepository.save(novoLivro);
    }
}

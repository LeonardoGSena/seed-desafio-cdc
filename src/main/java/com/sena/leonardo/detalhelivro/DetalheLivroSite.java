package com.sena.leonardo.detalhelivro;

import com.sena.leonardo.novolivro.BuscadorDeEntidades;
import com.sena.leonardo.novolivro.Livro;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class DetalheLivroSite {

   private final BuscadorDeEntidades buscadorDeEntidades;

    public DetalheLivroSite(BuscadorDeEntidades buscadorDeEntidades) {
        this.buscadorDeEntidades = buscadorDeEntidades;
    }

    public Optional<Livro> executa(@Valid Long id) {
        return Optional.ofNullable(buscadorDeEntidades.buscaPorId(Livro.class, id));
    }
}

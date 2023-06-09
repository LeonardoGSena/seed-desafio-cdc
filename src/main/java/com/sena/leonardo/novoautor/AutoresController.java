package com.sena.leonardo.novoautor;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//3
public class AutoresController {

  private final CadastroNovoAutor cadastroNovoAutor;

    public AutoresController(CadastroNovoAutor cadastroNovoAutor) {
        this.cadastroNovoAutor = cadastroNovoAutor;
    }

    @PostMapping(value = "/autores")
    @Transactional
    public String criaAutor(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = cadastroNovoAutor.executa(request);
        return autor.toString();
    }
}

package com.sena.leonardo.novolivro;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
//2
public class LivroController {

    private final CadastroNovoLivro cadastroNovoLivro;

    public LivroController(CadastroNovoLivro cadastroNovoLivro) {
        this.cadastroNovoLivro = cadastroNovoLivro;
    }

    @PostMapping(value = "/livros")
    @Transactional
    public String criaLivro(@RequestBody @Valid NovoLivroRequest request) {
        Livro novoLivro = cadastroNovoLivro.cadastraLivro(request);
        return novoLivro.toString();
    }

}

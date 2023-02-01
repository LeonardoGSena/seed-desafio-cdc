package com.sena.leonardo.novolivro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
//2
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/livros")
    @Transactional
    //1
    public String criaLivro(@RequestBody @Valid NovoLivroRequest request) {
        //1
        Livro novoLivro = request.toModel(manager);
        manager.persist(novoLivro);
        return novoLivro.toString();
    }

}

package com.sena.leonardo.novoautor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//3
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/autores")
    @Transactional
    //1
    //2
    public String criaAutor(@RequestBody @Valid NovoAutorRequest request) {
        //1
        Autor autor = request.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}

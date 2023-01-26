package com.sena.leonardo.novoautor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/autores")
    @Transactional
    public String cria(@Validated @RequestBody NovoAutorRequest request) {
        Autor autor = request.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}

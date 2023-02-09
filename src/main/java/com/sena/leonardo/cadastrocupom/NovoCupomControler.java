package com.sena.leonardo.cadastrocupom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCupomControler {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/cupons")
    @Transactional
    public String cria(@RequestBody @Valid NovoCupomRequest request) {
        Cupom novoCupom = request.toModel();
        manager.persist(novoCupom);
        return novoCupom.toString();
    }
}

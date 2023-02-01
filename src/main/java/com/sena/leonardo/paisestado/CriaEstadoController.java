package com.sena.leonardo.paisestado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/estados")
    @Transactional
    public String criaEstado(@RequestBody @Valid NovoEstadoRequest request) {
        Estado novoEstado = request.toModel(manager);
        manager.persist(novoEstado);
        return novoEstado.toString();
    }
}

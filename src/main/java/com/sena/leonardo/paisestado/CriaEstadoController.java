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

    private final CadastroEstado cadastroEstado;


    public CriaEstadoController(CadastroEstado cadastroEstado) {
        this.cadastroEstado = cadastroEstado;
    }

    @PostMapping(value = "/estados")
    @Transactional
    public String criaEstado(@RequestBody @Valid NovoEstadoRequest request) {
        Estado novoEstado = cadastroEstado.executa(request);
        return novoEstado.toString();
    }
}

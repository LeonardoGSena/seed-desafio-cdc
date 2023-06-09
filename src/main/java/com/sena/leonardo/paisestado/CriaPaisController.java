package com.sena.leonardo.paisestado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaPaisController {

    private final CadastroPais cadastroPais;


    public CriaPaisController(CadastroPais cadastroPais) {
        this.cadastroPais = cadastroPais;
    }

    @PostMapping(value = "/paises")
    @Transactional
    public String criaPais(@RequestBody @Valid NovoPaisRequest request) {
        Pais novoPais = cadastroPais.executa(request);
        return novoPais.toString();
    }
}

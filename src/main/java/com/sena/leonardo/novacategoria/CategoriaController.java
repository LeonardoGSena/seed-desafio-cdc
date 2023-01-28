package com.sena.leonardo.novacategoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/categorias")
    @Transactional
    public String criaCategoria(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria novaCategoria = new Categoria(request.getNome());
        manager.persist(novaCategoria);
        return novaCategoria.toString();
    }


}

package com.sena.leonardo.compartilhado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ListaTudo {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/lista-tudo")
    public HashMap<String, Object> list() {
        List autores = manager.createQuery("SELECT a FROM Autor a").getResultList();

        HashMap<String, Object> resultado = new HashMap<>();
        resultado.put("autores", autores.toString());

        List categorias = manager.createQuery("SELECT c FROM Categoria c").getResultList();
        resultado.put("categorias", categorias.toString());

        List livros = manager.createQuery("SELECT l FROM Livro l").getResultList();
        resultado.put("livros", livros.toString());

        return resultado;
    }
}

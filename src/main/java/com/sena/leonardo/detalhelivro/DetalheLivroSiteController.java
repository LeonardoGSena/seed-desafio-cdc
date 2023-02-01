package com.sena.leonardo.detalhelivro;

import com.sena.leonardo.novolivro.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
//3
public class DetalheLivroSiteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id) {
        //1
        Livro livroBuscado = manager.find(Livro.class, id);
        //1
        if (livroBuscado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //o find returna nulo, aí eu nao posso fazer nada. Tenho que verificar se vem nulo
//            return ResponseEntity.notFound().build();
        }
        //1
        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheSiteLivroResponse);
    }
}

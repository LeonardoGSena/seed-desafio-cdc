package com.sena.leonardo.detalhelivro;

import com.sena.leonardo.novolivro.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DetalheLivroSiteController {

   private final DetalheLivroSite detalheLivroSite;

    public DetalheLivroSiteController(DetalheLivroSite detalheLivroSite) {
        this.detalheLivroSite = detalheLivroSite;
    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id) {

        Livro livroBuscado = detalheLivroSite.executa(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheSiteLivroResponse);
    }
}

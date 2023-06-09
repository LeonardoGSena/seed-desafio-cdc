package com.sena.leonardo.novacategoria;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    private final CadastroNovaCategoria cadastroNovaCategoria;

    public CategoriaController(CadastroNovaCategoria cadastroNovaCategoria) {
        this.cadastroNovaCategoria = cadastroNovaCategoria;
    }

    @PostMapping(value = "/categorias")
    @Transactional
    public String criaCategoria(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria novaCategoria = cadastroNovaCategoria.executa(request);
        return novaCategoria.toString();
    }


}

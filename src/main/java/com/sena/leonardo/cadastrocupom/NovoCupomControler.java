package com.sena.leonardo.cadastrocupom;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCupomControler {

    private final CadastroNovoCupom cadastroNovoCupom;

    public NovoCupomControler(CadastroNovoCupom cadastroNovoCupom) {
        this.cadastroNovoCupom = cadastroNovoCupom;
    }

    @PostMapping(value = "/cupons")
    @Transactional
    public String cria(@RequestBody @Valid NovoCupomRequest request) {
        Cupom novoCupom = cadastroNovoCupom.executa(request);
        return novoCupom.toString();
    }
}

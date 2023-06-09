package com.sena.leonardo.cadastrocupom;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroNovoCupom {

    private final NovoCupomRepository novoCupomRepository;

    public CadastroNovoCupom(NovoCupomRepository novoCupomRepository) {
        this.novoCupomRepository = novoCupomRepository;
    }

    @Transactional
    public Cupom executa(@Valid DadosNovoCupom dados) {
        Cupom novoCupom = dados.toModel();
        return novoCupomRepository.save(novoCupom);
    }
}

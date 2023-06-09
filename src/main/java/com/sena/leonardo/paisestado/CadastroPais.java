package com.sena.leonardo.paisestado;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroPais {

    private final PaisRepository paisRepository;

    public CadastroPais(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Pais executa(@Valid DadosNovoPais dados) {
        Pais novoPais = dados.toModel();
        return paisRepository.save(novoPais);
    }
}

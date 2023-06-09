package com.sena.leonardo.novoautor;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroNovoAutor {

    private final AutorRepository autorRepository;

    public CadastroNovoAutor(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Autor executa(@Valid DadosNovoAutor dados) {
        Autor autor = dados.toModel();
        return autorRepository.save(autor);
    }
}

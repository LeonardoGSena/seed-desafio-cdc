package com.sena.leonardo.novacategoria;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroNovaCategoria {

    private final CategoryRepository categoryRepository;

    public CadastroNovaCategoria(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Categoria executa(@Valid DadosNovaCategoria dados) {
        Categoria categoria = dados.toModel();
        return categoryRepository.save(categoria);
    }
}

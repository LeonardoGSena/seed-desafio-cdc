package com.sena.leonardo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(NovaCategoriaRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovaCategoriaRequest request = (NovaCategoriaRequest) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Já existe uma categoria com esse nome: "
                    + request.getNome());
        }
    }
}

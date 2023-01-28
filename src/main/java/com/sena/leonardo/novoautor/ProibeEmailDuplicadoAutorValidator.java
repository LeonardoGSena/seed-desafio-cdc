package com.sena.leonardo.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(NovoAutorRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> possivelEmail = autorRepository.findByEmail(request.getEmail());

        if (possivelEmail.isPresent()) {
            errors.rejectValue("email", null, "Já existe um(a) autor(a) com esse email: " + request.getEmail());
        }
    }
}

package com.sena.leonardo.fechamentocompra;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificarDocumentoCpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) target;
        //verificar se o documento é valido
        if (!request.documentoValido()) {
            errors.rejectValue("documento", null, "O documento precisa ser cpf ou cnpj");
        }
    }
}

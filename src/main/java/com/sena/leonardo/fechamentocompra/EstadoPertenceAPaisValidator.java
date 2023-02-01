package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.paisestado.Estado;
import com.sena.leonardo.paisestado.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

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

        Pais pais = manager.find(Pais.class, request.getIdPais());
        Estado estado = manager.find(Estado.class, request.getIdEstado());

        if (!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado", null, "Esse estado não é do país selecionado");
        }
    }
}

package com.sena.leonardo.fechamentocompra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaCompraParte1Controller {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new VerificarDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator);
    }

    @PostMapping(value = "/compras")
    @Transactional
    public String cria(@RequestBody @Valid NovaCompraRequest request) {
        Compra novaCompra = request.toModel(manager);
        manager.persist(novaCompra);
        return novaCompra.toString();
    }
}

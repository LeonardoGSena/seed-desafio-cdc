package com.sena.leonardo.fechamentocompra;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaCompraParte1 {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new VerificarDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator);
    }

    @PostMapping(value = "/compras")
    @Transactional
    public String cria(@RequestBody @Valid NovaCompraRequest request) {
        return request.toString();
    }


    /**
     * email obrigatório e com formato adequado
     * nome obrigatório
     * sobrenome obrigatório
     * documento(cpf/cnpj) obrigatório e só precisa ser um cpf ou cnpj
     * endereco obrigatório
     * complemento obrigatório
     * cidade obrigatório
     * país obrigatório
     * se o país tiver estados, um estado precisa ser selecionado
     * estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados
     * telefone obrigatório
     * cep é obrigatório
     */
}

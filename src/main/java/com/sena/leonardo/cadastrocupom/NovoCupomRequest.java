package com.sena.leonardo.cadastrocupom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoCupomRequest {

    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;
    @Positive
    @NotNull
    private BigDecimal percentualDesconto;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public NovoCupomRequest(@NotBlank String codigo, @Positive @NotNull BigDecimal percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel() {
        return new Cupom(codigo, percentualDesconto, validade);
    }
}

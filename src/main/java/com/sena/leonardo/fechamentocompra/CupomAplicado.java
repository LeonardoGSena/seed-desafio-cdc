package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.cadastrocupom.Cupom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {

    @ManyToOne
    private Cupom cupom;
    @Positive
    @NotNull
    private BigDecimal percentualDescontoDoMomento;
    @Future
    @NotNull
    private LocalDate validadeDoMomento;

    @Deprecated
    public CupomAplicado() {
    }

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.percentualDescontoDoMomento = cupom.getPercentualDesconto();
        this.validadeDoMomento = cupom.getValidade();
    }

    @Override
    public String toString() {
        return "CupomAplicado{" +
                "cupom=" + cupom +
                ", percentualDescontoDoMomento=" + percentualDescontoDoMomento +
                ", validadeDoMomento=" + validadeDoMomento +
                '}';
    }
}

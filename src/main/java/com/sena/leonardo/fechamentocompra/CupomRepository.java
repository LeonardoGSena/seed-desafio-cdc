package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.cadastrocupom.Cupom;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends org.springframework.data.repository.Repository<Cupom, Long> {
    /**
     * Busca por codigo que existe no sistema
     * @param codigo
     * @return
     */
    public Cupom getByCodigo(String codigo);
}

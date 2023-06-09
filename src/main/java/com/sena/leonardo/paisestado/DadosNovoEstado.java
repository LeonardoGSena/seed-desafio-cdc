package com.sena.leonardo.paisestado;

import java.util.function.Function;

public interface DadosNovoEstado {

    public Estado toModel(Function<Long, Pais> carregaPais);
}

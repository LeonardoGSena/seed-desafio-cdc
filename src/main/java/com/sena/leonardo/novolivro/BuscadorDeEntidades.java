package com.sena.leonardo.novolivro;

public interface BuscadorDeEntidades {

    public <T> T buscaPorId(Class<T> klass, Long id);
}

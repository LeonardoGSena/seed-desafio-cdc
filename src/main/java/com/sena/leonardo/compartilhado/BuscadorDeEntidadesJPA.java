package com.sena.leonardo.compartilhado;

import com.sena.leonardo.novolivro.BuscadorDeEntidades;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * Implementacao de um buscador de entidades em cima da JPA
 */
@Component
public class BuscadorDeEntidadesJPA implements BuscadorDeEntidades {

    @Autowired
    private EntityManager manager;
    @Override
    public <T> T buscaPorId(Class<T> klass, Long id) {
        T entidade = manager.find(klass, id);
        Assert.state(Objects.nonNull(entidade),
                "A busca pela pela entidade do tipo " + klass
                        + " retornou nulo para o id " + id
                        + ". Isso não deveria acontecer");
        return entidade;
    }
}

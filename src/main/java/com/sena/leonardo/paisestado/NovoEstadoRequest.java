package com.sena.leonardo.paisestado;

import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.compartilhado.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

import java.util.function.Function;

public class NovoEstadoRequest implements DadosNovoEstado{

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public NovoEstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "NovoEstadoRequest{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }

    @Override
    public Estado toModel(Function<Long, Pais> carregaPais) {
        @NotNull
        Pais pais = carregaPais.apply(idPais);

        Assert.state(pais!=null, "Você está tentando cadastrar um estado para um país que não está cadastrado no banco " + idPais);

        return new Estado(this.nome, pais);
    }
}

package com.sena.leonardo.paisestado;

import com.sena.leonardo.novolivro.BuscadorDeEntidades;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CadastroEstado {

    private final EstadoRepository estadoRepository;
    private final BuscadorDeEntidades buscadorDeEntidades;
    public CadastroEstado(EstadoRepository estadoRepository, BuscadorDeEntidades buscadorDeEntidades) {
        this.estadoRepository = estadoRepository;
        this.buscadorDeEntidades = buscadorDeEntidades;
    }


    @Transactional
    public Estado executa(@Valid DadosNovoEstado dados) {
        Estado novoEstado = dados.toModel(idPais -> buscadorDeEntidades.buscaPorId(Pais.class, idPais));
        return estadoRepository.save(novoEstado);
    }
}


package com.sena.leonardo.controller;

import com.sena.leonardo.domain.Autor;
import com.sena.leonardo.domain.AutorRepository;
import com.sena.leonardo.domain.DadosCadastroAutor;
import com.sena.leonardo.domain.DadosDetalhamentoAuto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/autores")
public class ControllerAutor {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAutor(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = new Autor(dados);
        repository.save(autor);
        var uri = uriComponentsBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAuto(autor));
    }

}

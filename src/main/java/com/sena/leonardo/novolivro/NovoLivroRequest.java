package com.sena.leonardo.novolivro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.compartilhado.UniqueValue;
import com.sena.leonardo.novacategoria.Categoria;
import com.sena.leonardo.novoautor.Autor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoLivroRequest implements DadosNovoLivro {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;


    @JsonCreator
    public NovoLivroRequest(@NotBlank String titulo,
                            @NotBlank @Size(max = 500) String resumo,
                            @NotBlank String sumario,
                            @NotNull @Min(20) BigDecimal preco,
                            @Min(100) int numeroPaginas,
                            @NotBlank String isbn,
                            @Future @NotNull LocalDate dataPublicacao,
                            @NotNull Long idCategoria,
                            @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(Function<Long, Autor> carregaAutor, Function<Long, Categoria> carregaCategoria) {
        @NotNull
        Autor autor = carregaAutor.apply(idAutor);
        @NotNull
        Categoria categoria = carregaCategoria.apply(idCategoria);

        Assert.state(autor!=null, "Você está tentando cadastrar um livro para um autor que não esta cadastrado no banco " +idAutor);
        Assert.state(categoria!=null, "Você está tentando cadastrar um livro para uma categoria que não esta cadastrada no banco " +idCategoria);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
    }
}

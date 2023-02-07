package com.sena.leonardo.novolivro;

import com.sena.leonardo.novacategoria.Categoria;
import com.sena.leonardo.novoautor.Autor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
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
    private String isbn;
    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull
    @Valid
    @ManyToOne
    private Autor autor;
    @NotNull
    @Valid
    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @Min(100) int numeroPaginas,
                 @NotBlank String isbn,
                 @Future @NotNull LocalDate dataPublicacao,
                 @NotNull @Valid Autor autor,
                 @NotNull @Valid Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return isbn != null ? isbn.equals(livro.isbn) : livro.isbn == null;
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}

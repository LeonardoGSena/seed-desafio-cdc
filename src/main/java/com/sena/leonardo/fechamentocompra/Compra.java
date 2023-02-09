package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.paisestado.Estado;
import com.sena.leonardo.paisestado.Pais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

import java.util.function.Function;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotNull
    @ManyToOne
    private Pais pais;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @ManyToOne
    private Estado estado;
    @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
    private Pedido pedido;

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento, Pais pais, String telefone, String cep, Function<Compra, Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);
    }

    public void setEstado(@NotBlank @Valid Estado estado) {
        Assert.notNull(pais, "Não rola associar um estado enquanto um pais for nulo");
        Assert.isTrue(estado.pertenceAPais(pais), "Este estado não é do país associado a compra");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais=" + pais +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", pedido=" + pedido +
                '}';
    }
}

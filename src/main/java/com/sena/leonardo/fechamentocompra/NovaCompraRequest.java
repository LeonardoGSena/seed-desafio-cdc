package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.paisestado.Estado;
import com.sena.leonardo.paisestado.Pais;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

public class NovaCompraRequest {

    @NotBlank
    @Email
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
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @Valid
    @NotNull
    private NovoPedidoRequest pedido;

    public NovaCompraRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep, NovoPedidoRequest pedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "Você não deveria validar o documento se ele ainda nao tiver sido preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }

    @Override
    public String toString() {
        return "NovaCompraRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                '}';
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public Compra toModel(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, idPais);
        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, pais, telefone, cep);
        if (idEstado != null) {
            compra.setEstado(manager.find(Estado.class, idEstado));
        }

        Pedido novoPedido = pedido.toModel(compra, manager);
        return compra;
    }

    public boolean temEstado() {
        return idEstado!=null;
    }
}

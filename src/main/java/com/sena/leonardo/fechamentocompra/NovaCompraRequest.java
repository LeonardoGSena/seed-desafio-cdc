package com.sena.leonardo.fechamentocompra;

import com.sena.leonardo.compartilhado.ExistsId;
import com.sena.leonardo.paisestado.Estado;
import com.sena.leonardo.paisestado.Pais;
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
    @NotNull
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public NovaCompraRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
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
                '}';
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }
}

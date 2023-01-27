package com.sena.leonardo.novoautor;

public class FieldErrorOutputDto {

    private String field;
    private String errorMessage;

    public FieldErrorOutputDto() {
    }

    public FieldErrorOutputDto(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

package com.api.biblioteca.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String Livro_Ja_Cadastrado) {
        super(Livro_Ja_Cadastrado);
    }
}


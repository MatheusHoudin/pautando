package com.uds.pautando.core.error.exception;

public class EmptyDetailsException extends Exception {
    public EmptyDetailsException() {
        super("O detalhe fornecido está vazio");
    }
}

package com.uds.pautando.core.error.exception;

public class EmptyAuthorException extends Exception {
    public EmptyAuthorException() {
        super("O autor fornecido está vazio");
    }
}

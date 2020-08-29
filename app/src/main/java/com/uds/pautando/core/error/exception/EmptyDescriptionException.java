package com.uds.pautando.core.error.exception;

public class EmptyDescriptionException extends Exception {
    public EmptyDescriptionException() {
        super("A descrição fornecida está vazia");
    }
}

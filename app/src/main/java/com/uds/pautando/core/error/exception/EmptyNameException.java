package com.uds.pautando.core.error.exception;

public class EmptyNameException extends Exception {
    public EmptyNameException() {
        super("O nome fornecido está vazio");
    }
}

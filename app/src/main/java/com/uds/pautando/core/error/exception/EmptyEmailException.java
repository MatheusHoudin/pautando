package com.uds.pautando.core.error.exception;

public class EmptyEmailException extends Exception {
    public EmptyEmailException() {
        super("O email fornecido está vazio");
    }
}

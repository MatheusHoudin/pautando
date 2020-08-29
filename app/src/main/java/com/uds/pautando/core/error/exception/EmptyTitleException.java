package com.uds.pautando.core.error.exception;

public class EmptyTitleException extends Exception {
    public EmptyTitleException() {
        super("O título fornecido está vazio");
    }
}

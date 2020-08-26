package com.uds.pautando.error.exception;

public class EmptyEmailException extends Exception {
    public EmptyEmailException() {
        super("The provided email is empty");
    }
}

package com.uds.pautando.core.error.exception;

public class EmailAndPasswordAndNameNotProvidedException extends Exception {
    public EmailAndPasswordAndNameNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

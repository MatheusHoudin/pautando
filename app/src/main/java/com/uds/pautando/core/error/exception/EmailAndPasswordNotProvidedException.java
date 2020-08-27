package com.uds.pautando.core.error.exception;

public class EmailAndPasswordNotProvidedException extends Exception {
    public EmailAndPasswordNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

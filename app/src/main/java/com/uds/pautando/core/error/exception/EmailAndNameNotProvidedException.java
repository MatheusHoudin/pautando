package com.uds.pautando.core.error.exception;

public class EmailAndNameNotProvidedException extends Exception {
    public EmailAndNameNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

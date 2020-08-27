package com.uds.pautando.core.error.exception;

public class NameAndPasswordNotProvidedException extends Exception {
    public NameAndPasswordNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

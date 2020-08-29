package com.uds.pautando.core.error.exception;

public class DetailsAndAuthorNotProvidedException extends Exception {
    public DetailsAndAuthorNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

package com.uds.pautando.core.error.exception;

public class DescriptionAndDetailsAndAuthorNotProvidedException extends  Exception {
    public DescriptionAndDetailsAndAuthorNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

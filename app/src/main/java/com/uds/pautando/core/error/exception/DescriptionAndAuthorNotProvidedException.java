package com.uds.pautando.core.error.exception;

public class DescriptionAndAuthorNotProvidedException extends Exception{
    public DescriptionAndAuthorNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

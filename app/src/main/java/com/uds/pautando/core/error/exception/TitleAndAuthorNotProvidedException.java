package com.uds.pautando.core.error.exception;

public class TitleAndAuthorNotProvidedException extends Exception{
    public TitleAndAuthorNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

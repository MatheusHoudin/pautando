package com.uds.pautando.core.error.exception;

public class TitleAndDescriptionAndDetailsAndAuthorNotProvidedException extends Exception{
    public TitleAndDescriptionAndDetailsAndAuthorNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

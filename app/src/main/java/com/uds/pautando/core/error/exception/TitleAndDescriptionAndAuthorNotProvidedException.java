package com.uds.pautando.core.error.exception;

public class TitleAndDescriptionAndAuthorNotProvidedException extends Exception{
    public TitleAndDescriptionAndAuthorNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

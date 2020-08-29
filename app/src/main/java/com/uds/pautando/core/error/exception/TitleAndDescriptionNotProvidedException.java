package com.uds.pautando.core.error.exception;

public class TitleAndDescriptionNotProvidedException extends Exception{
    public TitleAndDescriptionNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

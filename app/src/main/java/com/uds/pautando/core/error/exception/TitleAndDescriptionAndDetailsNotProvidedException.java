package com.uds.pautando.core.error.exception;

public class TitleAndDescriptionAndDetailsNotProvidedException extends Exception{
    public TitleAndDescriptionAndDetailsNotProvidedException() {
        super("Este campo não foi preenchido");
    }
}

package com.uds.pautando.core.error.exception;

public class TitleAndDetailsNotProvidedException extends Exception{
    public TitleAndDetailsNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

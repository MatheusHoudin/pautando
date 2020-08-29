package com.uds.pautando.core.error.exception;

public class DescriptionAndDetailsNotProvidedException extends Exception {
    public DescriptionAndDetailsNotProvidedException() {
        super("Este campo não foi fornecido");
    }
}

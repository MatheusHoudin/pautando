package com.uds.pautando.core.error.exception;

public class ShortPasswordException extends Exception {
    public ShortPasswordException(){
        super("Sua senha deve ter no mínimo 6 caracteres");
    }
}

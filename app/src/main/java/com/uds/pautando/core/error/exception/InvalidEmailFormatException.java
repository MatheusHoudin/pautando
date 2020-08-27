package com.uds.pautando.core.error.exception;

public class InvalidEmailFormatException extends Exception {
    public InvalidEmailFormatException(){
        super("O email fornecido não é válido, tente algo como uds@pautando.com");
    }
}

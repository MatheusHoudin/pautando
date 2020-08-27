package com.uds.pautando.core.error.exception;

public class EmptyPasswordException extends Exception{
    public EmptyPasswordException(){
        super("A senha fornecida está vazia");
    }
}

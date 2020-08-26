package com.uds.pautando.core.error.exception;

public class ShortPasswordException extends Exception {
    public ShortPasswordException(){
        super("Your password must have at least 6 characters");
    }
}

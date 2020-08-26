package com.uds.pautando.error.exception;

public class ShortPasswordException extends Exception {
    public ShortPasswordException(){
        super("Your password must have at least 6 characters");
    }
}

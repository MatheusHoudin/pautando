package com.uds.pautando.error.exception;

public class InvalidEmailFormatException extends Exception {
    public InvalidEmailFormatException(){
        super("The provided email is not valid");
    }
}

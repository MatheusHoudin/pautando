package com.uds.pautando.core.error.exception;

public class EmptyPasswordException extends Exception{
    public EmptyPasswordException(){
        super("The password you provided is empty");
    }
}

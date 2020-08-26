package com.uds.pautando.error.exception;

public class EmptyPasswordException extends Exception{
    public EmptyPasswordException(){
        super("The password you provided is empty");
    }
}

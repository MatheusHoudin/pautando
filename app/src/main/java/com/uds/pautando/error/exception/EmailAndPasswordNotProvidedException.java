package com.uds.pautando.error.exception;

public class EmailAndPasswordNotProvidedException extends Exception {
    public EmailAndPasswordNotProvidedException() {
        super("The fields were not filled out");
    }
}

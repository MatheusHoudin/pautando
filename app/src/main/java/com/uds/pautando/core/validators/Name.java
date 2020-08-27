package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyNameException;

public class Name {
    private String value;

    public Name(String value) throws EmptyNameException {
        this.setValue(value);
    }

    public void setValue(String value) throws EmptyNameException {
        if(value==null || value.isEmpty()) {
            throw new EmptyNameException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

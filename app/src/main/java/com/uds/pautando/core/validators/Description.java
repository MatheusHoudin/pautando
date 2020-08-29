package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyDescriptionException;

public class Description {
    private String value;

    public Description(String value) throws EmptyDescriptionException {
        this.setValue(value);
    }

    public void setValue(String value) throws EmptyDescriptionException {
        if(value==null || value.isEmpty()) {
            throw new EmptyDescriptionException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

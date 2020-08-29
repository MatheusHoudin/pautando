package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyDescriptionException;
import com.uds.pautando.core.error.exception.EmptyDetailsException;

public class Details {
    private String value;

    public Details(String value) throws EmptyDetailsException {
        this.setValue(value);
    }

    public void setValue(String value) throws EmptyDetailsException {
        if(value==null || value.isEmpty()) {
            throw new EmptyDetailsException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

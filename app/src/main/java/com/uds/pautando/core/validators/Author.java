package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyAuthorException;
import com.uds.pautando.core.error.exception.EmptyDescriptionException;

public class Author {
    private String value;

    public Author(String value) throws EmptyAuthorException {
        this.setValue(value);
    }

    public void setValue(String value) throws EmptyAuthorException {
        if(value==null || value.isEmpty()) {
            throw new EmptyAuthorException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

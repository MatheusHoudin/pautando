package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyNameException;
import com.uds.pautando.core.error.exception.EmptyTitleException;

public class Title {
    private String value;

    public Title(String value) throws EmptyTitleException {
        this.setValue(value);
    }

    public void setValue(String value) throws EmptyTitleException {
        if(value==null || value.isEmpty()) {
            throw new EmptyTitleException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

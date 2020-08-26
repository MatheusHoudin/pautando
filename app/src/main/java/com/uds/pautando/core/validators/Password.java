package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.core.error.exception.ShortPasswordException;

public class Password {
    private String value;

    public Password(String value) throws Exception{
        this.setValue(value);
    }

    private void setValue(String value) throws Exception{
        if(value == null || value.isEmpty()) {
            throw new EmptyPasswordException();
        }else if(value.length() < 6) {
            throw new ShortPasswordException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

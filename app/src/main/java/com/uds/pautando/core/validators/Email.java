package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.InvalidEmailFormatException;

import java.util.regex.Pattern;

public class Email {
    private String value;

    public Email(String value) throws Exception{
        this.setValue(value);
    }

    private void setValue(String value) throws Exception{
        if(value == null || value.isEmpty()) {
            throw new EmptyEmailException();
        }else if(!Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(value).matches()) {
            throw new InvalidEmailFormatException();
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}

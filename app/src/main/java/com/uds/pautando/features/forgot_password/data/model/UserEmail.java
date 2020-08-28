package com.uds.pautando.features.forgot_password.data.model;

import com.uds.pautando.core.validators.Email;

public class UserEmail {
    private Email email;

    public UserEmail(String value) throws Exception {
        this.email = new Email(value);
    }

    public Email getEmail() {
        return email;
    }
}

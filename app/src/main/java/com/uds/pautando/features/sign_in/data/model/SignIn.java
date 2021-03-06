package com.uds.pautando.features.sign_in.data.model;

import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.validators.Email;
import com.uds.pautando.core.validators.Password;

public class SignIn {
    private Email email;
    private Password password;

    public SignIn(String email, String password) throws Exception{
        if((email == null || email.isEmpty()) && (password == null || password.isEmpty())) {
            throw new EmailAndPasswordNotProvidedException();
        }else{
            this.email = new Email(email);
            this.password = new Password(password);
        }
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }
}

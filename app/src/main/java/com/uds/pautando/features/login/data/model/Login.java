package com.uds.pautando.features.login.data.model;

import com.uds.pautando.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.validators.Email;
import com.uds.pautando.validators.Password;

public class Login {
    private Email email;
    private Password password;

    public Login(String email, String password) throws Exception{
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

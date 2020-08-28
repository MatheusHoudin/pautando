package com.uds.pautando.features.sign_up.data.model;

import com.uds.pautando.core.error.exception.EmailAndNameNotProvidedException;
import com.uds.pautando.core.error.exception.EmailAndPasswordAndNameNotProvidedException;
import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyNameException;
import com.uds.pautando.core.error.exception.NameAndPasswordNotProvidedException;
import com.uds.pautando.core.validators.Email;
import com.uds.pautando.core.validators.Name;
import com.uds.pautando.core.validators.Password;

public class SignUpUser {
    private Name name;
    private Email email;
    private Password password;

    public SignUpUser(String name, String email, String password) throws Exception {
        if((name == null || name.isEmpty()) && (email == null || email.isEmpty()) && (password == null || password.isEmpty())) {
            throw new EmailAndPasswordAndNameNotProvidedException();
        }else if((name == null || name.isEmpty()) && (email == null || email.isEmpty())) {
            throw new EmailAndNameNotProvidedException();
        }else if((email == null || email.isEmpty()) && (password == null || password.isEmpty())) {
            throw new EmailAndPasswordNotProvidedException();
        }else if((name == null || name.isEmpty()) && (password == null || password.isEmpty())) {
            throw new NameAndPasswordNotProvidedException();
        }else{
            this.name = new Name(name);
            this.email = new Email(email);
            this.password = new Password(password);
        }
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }
}

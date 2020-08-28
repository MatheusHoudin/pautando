package com.uds.pautando.models;

import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.features.sign_in.data.model.SignIn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SignInTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void assertEmailAndPasswordIsEmpty() throws Exception {
        exception.expect(EmailAndPasswordNotProvidedException.class);
        new SignIn(null,null);
    }

    @Test
    public void assertPasswordIsEmpty() throws Exception {
        exception.expect(EmptyPasswordException.class);
        new SignIn("matheusdin04@gmail.com",null);
    }

    @Test
    public void assertEmailIsEmpty() throws Exception {
        exception.expect(EmptyEmailException.class);
        new SignIn(null,"123456");
    }
}

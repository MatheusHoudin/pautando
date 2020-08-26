package com.uds.pautando.models;

import com.uds.pautando.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.error.exception.EmptyEmailException;
import com.uds.pautando.error.exception.EmptyPasswordException;
import com.uds.pautando.features.login.data.model.Login;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoginTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void assertEmailAndPasswordIsEmpty() throws Exception {
        exception.expect(EmailAndPasswordNotProvidedException.class);
        new Login(null,null);
    }

    @Test
    public void assertPasswordIsEmpty() throws Exception {
        exception.expect(EmptyPasswordException.class);
        new Login("matheusdin04@gmail.com",null);
    }

    @Test
    public void assertEmailIsEmpty() throws Exception {
        exception.expect(EmptyEmailException.class);
        new Login(null,"123456");
    }
}

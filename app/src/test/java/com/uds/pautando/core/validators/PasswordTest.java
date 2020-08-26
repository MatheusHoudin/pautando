package com.uds.pautando.core.validators;

import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.core.error.exception.ShortPasswordException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class PasswordTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void assertPasswordIsEmpty() throws Exception {
        exception.expect(EmptyPasswordException.class);
        new Password("");
    }
    @Test
    public void assertShortPassword() throws Exception {
        exception.expect(ShortPasswordException.class);
        new Password("1");
        exception.expect(EmptyPasswordException.class);
        new Password("12345");
    }
    @Test
    public void assertPasswordIsValid() throws Exception {
        Password password = new Password("123456");
        assertNotNull(password.getValue());
    }
}

package com.uds.pautando.validators;

import com.uds.pautando.error.exception.EmptyEmailException;
import com.uds.pautando.error.exception.InvalidEmailFormatException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EmailTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void assertEmailIsEmpty() throws Exception {
        exception.expect(EmptyEmailException.class);
        new Email("");
    }
    @Test
    public void assertEmailIsNotValid() throws Exception {
        exception.expect(InvalidEmailFormatException.class);
        new Email("a");
        exception.expect(InvalidEmailFormatException.class);
        new Email("a@");
        exception.expect(InvalidEmailFormatException.class);
        new Email("a@a");
    }
    @Test
    public void assertEmailIsValidAndIsSet() throws Exception {
        Email email = new Email("matheusdin04@gmail.com");
        assertNotNull(email.getValue());
    }
}

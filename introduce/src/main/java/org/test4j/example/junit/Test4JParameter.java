package org.test4j.example.junit;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.test4j.example.junit.trade.UserValidator;
import org.test4j.junit.Test4J;
import org.test4j.junit.annotations.DataFrom;

@SuppressWarnings("rawtypes")
public class Test4JParameter extends Test4J {
    @Test
    @DataFrom("dataForUserValidate")
    public void testUserValidate(String user, String pw, boolean expected) {
        assertEquals(expected, UserValidator.validate(user, pw));
    }

    public static Iterator dataForUserValidate() {
        return new DataIterator() {
            {
                data("user01", "123456", true);
                data("helloworld", "123456", false);
                data("david", "re*ads", false);
                data("goodone", "onegood", true);
            }
        };
    }
}

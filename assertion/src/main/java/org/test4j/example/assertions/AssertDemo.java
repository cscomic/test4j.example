package org.test4j.example.assertions;

import org.junit.Test;
import org.test4j.junit.Test4J;

public class AssertDemo extends Test4J {
    @Test
    public void test() {
        assert false;
        System.out.println("Hello, Assertion!");
    }

    @Test
    public void testCatchAssert() {
        try {
            throw new AssertionError("test");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

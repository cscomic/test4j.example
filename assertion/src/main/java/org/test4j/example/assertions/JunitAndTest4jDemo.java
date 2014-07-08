package org.test4j.example.assertions;

import org.junit.Assert;
import org.junit.Test;
import org.test4j.example.assertions.pojo.UserA;
import org.test4j.junit.Test4J;

public class JunitAndTest4jDemo extends Test4J {
    @Test
    public void testUserNameAndAgeEquals() {
        UserA expected = new UserA("jobs.he", 30);
        // 执行某个业务方法，返回一个User对象
        UserA actual = new UserA("jobs.he", 30);
        Assert.assertTrue(isUserNameAndAgeEquals(actual, expected));
    }

    /**
     * 判断2个User对象名字和年龄是否相等
     */
    private boolean isUserNameAndAgeEquals(UserA actual, UserA expected) {
        if (actual == null || expected == null) {
            return false;
        }
        String expectedName = expected.getName();
        if (expectedName == null) {
            if (actual.getName() != null) {
                return false;
            }
        } else if (expectedName.equals(actual.getName()) == false) {
            return false;
        }
        if (expected.getAge() == actual.getAge()) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void testUserNameAndAgeEquals2() {
        UserA expected = new UserA("jobs.he", 30);
        UserA actual = new UserA("jobs.he", 30);
        want.object(actual).reflectionEq(expected);
    }
}

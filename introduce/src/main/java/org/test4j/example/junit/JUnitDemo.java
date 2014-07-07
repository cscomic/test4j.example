package org.test4j.example.junit;

import org.junit.Test;
import org.test4j.junit.Test4J;

public class JUnitDemo extends Test4J {
    @Test
    public void testDemo() {
        System.out.println("执行具体测试逻辑");
    }
}

package org.test4j.example.assertions;

import org.junit.Test;
import org.test4j.hamcrest.matcher.string.StringMode;
import org.test4j.junit.Test4J;
import org.test4j.module.Test4JException;

public class StringEqualDemo extends Test4J {
    @Test
    public void testStringEqual() {
        String actual = "I am a string.";
        // 断言实际只actual等于期望值：I am a string.
        want.string(actual).isEqualTo("I am a string.");
        // eq是isEqualTo的简写
        want.string(actual).eq("I am a string.");
    }

    @Test(expected = Test4JException.class)
    public void testStringEqualError() {
        String actual = "I am a string.";
        want.string(actual).equals("I am a string.");
    }

    @Test
    public void testIgnoreCase() {
        String actual = "I AM A STRING.";
        want.string(actual).eq("i am a STRING.", StringMode.IgnoreCase);
    }

    /**
     * 快捷api: eqIgnoreCase
     **/
    @Test
    public void testIgnoreCaseEqual() {
        String actual = "I AM A STRING.";
        want.string(actual).eqIgnoreCase("i am a STRING.");
    }

    @Test
    public void testIgnoreSpace() {
        String actual = "I am\t\n a \f string.";
        want.string(actual).eq(" Iam a string. ", StringMode.IgnoreSpace);
    }

    /**
     * 快捷api: eqIgnoreSpace
     **/
    @Test
    public void testIgnoreSpaceEqual() {
        String actual = "I am\t\n a \f string.";
        want.string(actual).eqIgnoreSpace(" Iam a string. ");
    }

    @Test
    public void testIgnoreQuato() {
        String actual = "{name:\"darui.wu\", address:\"杭州市\"}";
        want.string(actual).eq("{'name':'darui.wu', 'address':'杭州市'}", StringMode.IgnoreQuato);
    }

    @Test
    public void testSameAsSpace() {
        String actual = "I am\t\n a \f string.";
        want.string(actual).eq("I am a string.", StringMode.SameAsSpace);
    }

    /**
     * 快捷api: eqWithStripSpace
     **/
    @Test
    public void testEqWithStripSpace() {
        String actual = "I am\t\n a \f string.";
        want.string(actual).eqWithStripSpace("I am a string.");
    }

    @Test
    public void testSameAsQuato() {
        String actual = "{name:\"darui.wu\", address:\"杭州市\"}";
        want.string(actual).eq("{name:'darui.wu', address:'杭州市'}", StringMode.SameAsQuato);
    }

    @Test
    public void testSameAsSlash() {
        String actual = "d:/abc\\e/1.txt";
        want.string(actual).eq("d:/abc/e/1.txt", StringMode.SameAsSlash);
    }

    @Test
    public void testStringEqCompound() {
        String actual = "{name: \"darui.wu\", address: \"杭州市\"}";
        want.string(actual).eq("{name:'darui.wu', address:'杭州市'}", StringMode.SameAsQuato, StringMode.IgnoreSpace);
    }

    @Test
    public void testContains() {
        String actual = "{name: 'darui.wu', address: '杭州市'}";
        want.string(actual).contains("darui.wu");
    }

    /**
     * 断言字符串在忽略空格的情况下，包含2个子字符串"darui.wu", "zhejianghangzhou"
     **/
    @Test
    public void testContains_MultipleStr() {
        String actual = "{name: 'darui.wu', address: 'zhengjiang hangzhou'}";
        want.string(actual).contains(new String[] { "darui.wu", "zhejianghangzhou" }, StringMode.IgnoreSpace);
    }

    @Test
    public void testContainsInOrder() {
        String actual = "abc efg";
        want.string(actual).containsInOrder("abc", "efg");
    }

    /**
     * 在不忽略大小写的情况下,希望字符串"Abc Efg"包含子串"abc","efg"。 ,但实际上不含子串"abc"，断言抛出错误。
     */
    @Test(expected = AssertionError.class)
    public void testContainsInOrder_NoModes() {
        String actual = "Abc Efg";
        want.string(actual).containsInOrder(new String[] { "abc", "efg" });
    }

    /**
     * 在忽略大小写的情况下,字符串"Abc Efg"包含子串"abc","efg"
     */
    @Test
    public void testContainsInOrder_HasModes() {
        String actual = "Abc Efg";
        want.string(actual).containsInOrder(new String[] { "abc", "efg" }, StringMode.IgnoreCase);
    }

    /**
     * 希望字符串不包含子串"abc"和"efg"，但实际上包含了"abc"，断言会抛出错误
     */
    @Test(expected = AssertionError.class)
    public void testNotContains_Failure() {
        want.string("abc cba").notContain(new String[] { "abc", "efg" });
    }

    /**
     * 希望字符串不包含子串"acb"和"efg"，实际上也不包含，断言通过
     */
    public void testNotContains() {
        want.string("abc cba").notContain(new String[] { "acb", "efg" });
    }

    /**
     * 在忽略空格和大小写的情况下，实际字符串以abc开头
     */
    @Test
    public void testStart() {
        want.string("a B C=====").start("abc", StringMode.IgnoreCase, StringMode.IgnoreSpace);
    }

    /**
     * 在忽略空格和大小写的情况下，实际字符串以abc结尾
     */
    @Test
    public void testEnd() {
        want.string("=====a b C").end("abc", StringMode.IgnoreCase, StringMode.IgnoreSpace);
    }

    /**
     * 正则表达式演示，期望实际值是个163邮箱
     */
    @Test
    public void testRegular_StringDoesIsAEMail() {
        String actual = "darui.wu@163.com";
        want.string(actual).regular("[\\w\\d\\.\\_]+@163\\.com");
    }

    /**
     * 期望用户邮箱是163邮箱或者gmail邮箱，且不是sohu邮箱和sina邮箱
     */
    @Test
    public void testInCadidateStrings() {
        String actual = "darui.wu@163.com";
        want.string(actual).in("darui.wu@163.com", "darui.wu@gmail.com").notIn("darui.wu@sohu.com", "darui.wu@sina.cn");
    }

    /**
     * 期望字符串是null
     */
    public void testNull() {
        String actual = null;
        want.string(actual).isNull();
    }

    /**
     * 期望字符串非空且不是空串
     */
    public void testNotNull() {
        String actual = "adfasd";
        want.string(actual).notNull().notBlank();
    }
}

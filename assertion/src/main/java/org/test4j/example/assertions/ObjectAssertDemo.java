package org.test4j.example.assertions;

import org.junit.Test;
import org.test4j.example.assertions.pojo.UserA;
import org.test4j.example.assertions.pojo.UserB;
import org.test4j.example.assertions.pojo.UserC;
import org.test4j.hamcrest.matcher.property.reflection.EqMode;
import org.test4j.hamcrest.matcher.string.StringMode;
import org.test4j.junit.Test4J;

@SuppressWarnings("serial")
public class ObjectAssertDemo extends Test4J {
    @Test
    public void testEqual() {
        UserA user = new UserA("jobs.he", 30);
        want.object(user).eq(new UserA("jobs.he", 30));
    }

    @Test
    public void testReflectEqual() {
        UserA user = new UserA("jobs.he", 30);
        want.object(user).eqByReflect(new UserA("jobs.he", 30));
    }

    @Test
    public void testReflectEqual2() {
        UserA user = new UserA("jobs.he", 30);
        want.object(user).eqByReflect(new UserA("jobs.he1", 30));
    }

    @Test
    public void testEqual_eqByReflect_IgnoreDefault() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        want.object(user).eqByReflect(new UserB("jobs.he", "浙江省杭州市", null, 0), EqMode.IGNORE_DEFAULTS);
    }

    @Test
    public void testEqual_eqByReflect_IgnoreOrder() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        user.setPhones(new String[] { "15990038123", "13906471234" });
        UserB expected = new UserB("jobs.he", null, "310010", 30);
        expected.setPhones(new String[] { "13906471234", "15990038123" });
        want.object(user).eqByReflect(expected, EqMode.IGNORE_DEFAULTS, EqMode.IGNORE_ORDER);
    }

    @Test
    public void testPropertyEq() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        want.object(user).propertyEq("name", "jobs.he");
    }

    @Test
    public void testPropertyEq_StringMode() {
        UserB user = new UserB("Jobs . He", "浙江省杭州市", "310010", 30);
        // 忽略name属性中的大小写和空格
        want.object(user).propertyEq("name", "jobs.he", StringMode.IgnoreSpace, StringMode.IgnoreCase);
    }

    @Test
    public void testPropertyEq_EqMode() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        user.setPhones(new String[] { "15990038123", "13906471234" });
        want.object(user).propertyEq("phones", new String[] { "13906471234", "15990038123" }, EqMode.IGNORE_ORDER);
    }

    @Test
    public void testPropertyEqMap() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        want.object(user).propertyEqMap(new DataMap() {
            {
                this.put("name", "jobs.he");
                this.put("address", "浙江省杭州市");
            }
        });
    }

    @Test
    public void testPropertyEqMap_EqMode() {
        UserB user = new UserB("jobs.he", "浙江省杭州市", "310010", 30);
        user.setPhones(new String[] { "15990038123", "13906471234" });
        want.object(user).propertyEqMap(new DataMap() {
            {
                this.put("name", "jobs.he");
                this.put("address", "浙江省杭州市");
                this.put("phones", new String[] { "13906471234", "15990038123" });
            }
        }, EqMode.IGNORE_ORDER);
    }

    @Test
    public void testCascadeProperty() {
        UserC user = new UserC("jobs.he");
        user.setPhones(new String[] { "15990038123", "13906471234" });
        user.setAssistor(new UserC("david") {
            {
                this.setPhones(new String[] { "086-571-88888888", "13305718888" });
            }
        });
        want.object(user).propertyEq("assistor.name", "david").propertyEqMap(new DataMap() {
            {
                this.put("name", "jobs.he");
                this.put("phones", new String[] { "13906471234", "15990038123" });
                this.put("assistor.phones", new String[] { "13305718888", "086-571-88888888" });
            }
        }, EqMode.IGNORE_ORDER);
    }
}

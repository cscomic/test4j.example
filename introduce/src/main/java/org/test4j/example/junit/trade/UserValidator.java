package org.test4j.example.junit.trade;

public class UserValidator {
    /**
     * 校验用户名，密码是否合法
     * 
     * @param user
     * @param pw
     * @return
     */
    public static boolean validate(String userName, String password) {
        if (userName.length() <= 4 || userName.length() > 8)
            return false;
        if (password.length() <= 4 || password.length() > 8)
            return false;
        if (userName.contains("@"))
            return false;
        if (password.contains("*"))
            return false;
        return true;
    }
}

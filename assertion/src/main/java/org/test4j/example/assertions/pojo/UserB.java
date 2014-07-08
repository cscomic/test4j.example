package org.test4j.example.assertions.pojo;

public class UserB {
    /**
     * 用户姓名
     */
    private String   name;
    /**
     * 住址
     */
    private String   address;
    /**
     * 邮编
     */
    private String   postcode;
    /**
     * 年龄
     */
    private int      age;
    /**
     * 电话列表
     */
    private String[] phones;

    public UserB(String name, String address, String postcode, int age) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}

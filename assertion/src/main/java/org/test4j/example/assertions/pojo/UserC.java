package org.test4j.example.assertions.pojo;

public class UserC {
    private String   name;

    private String[] phones;

    private UserC    assistor;

    public UserC() {
    }

    public UserC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public UserC getAssistor() {
        return assistor;
    }

    public void setAssistor(UserC assistor) {
        this.assistor = assistor;
    }
}

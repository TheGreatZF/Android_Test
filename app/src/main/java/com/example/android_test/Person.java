package com.example.android_test;

public class Person {
    private String name;
    private String phone;
    private int headID;

    public Person(String name, String phone, int headID) {
        this.name = name;
        this.phone = phone;
        this.headID = headID;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHeadID() {
        return headID;
    }

    public void setHeadID(int headID) {
        this.headID = headID;
    }
}

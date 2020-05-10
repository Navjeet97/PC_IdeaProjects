package com.navjeet;


// ArrayList to be created will accept a custom class having name and phone number named Contacts


import java.util.Objects;

public class Contacts {

    private String name;
    private String phoneNumber;

    public Contacts() {
    }

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // generating toString method

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(name, contacts.name) &&
                Objects.equals(phoneNumber, contacts.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, phoneNumber);
    }
}

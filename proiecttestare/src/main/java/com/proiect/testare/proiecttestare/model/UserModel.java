package com.proiect.testare.proiecttestare.model;

public class UserModel {

    private Integer code;
    private String firstName;
    private String lastName;
    private String email;

    public UserModel() {
    }

    public UserModel(Integer code, String firstName, String lastName, String email) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

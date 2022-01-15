package com.c0721g2srsrealestatebe.payload.request;

public class CustomerSocial {
    private String name;
    private String email;
    private String password;

    public CustomerSocial() {
        //constructor
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

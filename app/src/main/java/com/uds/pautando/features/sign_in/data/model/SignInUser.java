package com.uds.pautando.features.sign_in.data.model;

public class SignInUser {
    private String uid;
    private String email;
    private String name;

    public SignInUser(String uid, String email, String name) {
        this.uid = uid;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }


}

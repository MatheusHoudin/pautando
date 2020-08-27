package com.uds.pautando.features.sign_in.domain.usecase;

public class LoginParams {
    private String email;
    private String password;

    public LoginParams(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

package com.uds.pautando.features.sign_in.domain.usecase;

public class SignInParams {
    private String email;
    private String password;

    public SignInParams(String email, String password) {
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

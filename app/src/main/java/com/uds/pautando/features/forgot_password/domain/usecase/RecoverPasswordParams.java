package com.uds.pautando.features.forgot_password.domain.usecase;

public class RecoverPasswordParams {
    private String email;

    public RecoverPasswordParams(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

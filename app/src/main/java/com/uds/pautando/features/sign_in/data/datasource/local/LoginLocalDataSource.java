package com.uds.pautando.features.sign_in.data.datasource.local;

public interface LoginLocalDataSource {
    void saveLoginData(String uid, String email);
}

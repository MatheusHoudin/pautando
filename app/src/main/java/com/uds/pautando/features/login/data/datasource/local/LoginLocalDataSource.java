package com.uds.pautando.features.login.data.datasource.local;

public interface LoginLocalDataSource {
    void saveLoginData(String uid, String email);
}

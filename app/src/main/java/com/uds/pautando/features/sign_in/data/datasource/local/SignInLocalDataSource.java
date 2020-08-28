package com.uds.pautando.features.sign_in.data.datasource.local;

import com.uds.pautando.features.sign_in.data.model.SignInUser;

public interface SignInLocalDataSource {
    void saveUserData(String uid, String name, String email);
    SignInUser getCurrentUser();
}

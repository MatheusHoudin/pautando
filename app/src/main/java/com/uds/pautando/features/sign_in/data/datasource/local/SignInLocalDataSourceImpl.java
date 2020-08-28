package com.uds.pautando.features.sign_in.data.datasource.local;

import com.uds.pautando.core.preferences.MyPreferences;
import com.uds.pautando.features.sign_in.data.model.SignInUser;

public class SignInLocalDataSourceImpl implements SignInLocalDataSource {
    @Override
    public void saveUserData(String uid, String name, String email) {
        MyPreferences.getInstance().saveUserData(uid,name,email);
    }

    @Override
    public SignInUser getCurrentUser() {
        return MyPreferences.getInstance().getUser();
    }
}

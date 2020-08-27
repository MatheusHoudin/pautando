package com.uds.pautando.features.sign_in.data.datasource.local;

import com.uds.pautando.core.preferences.MyPreferences;

public class SignInLocalDataSourceImpl implements SignInLocalDataSource {
    @Override
    public void saveLoginData(String uid, String email) {
        MyPreferences.getInstance().saveLoginData(uid,email);
    }
}

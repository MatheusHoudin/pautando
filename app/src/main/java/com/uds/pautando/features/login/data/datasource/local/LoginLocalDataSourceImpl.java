package com.uds.pautando.features.login.data.datasource.local;

import com.uds.pautando.core.preferences.MyPreferences;

public class LoginLocalDataSourceImpl implements LoginLocalDataSource{
    @Override
    public void saveLoginData(String uid, String email) {
        MyPreferences.getInstance().saveLoginData(uid,email);
    }
}

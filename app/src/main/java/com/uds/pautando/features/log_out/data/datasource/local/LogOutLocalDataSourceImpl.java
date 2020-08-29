package com.uds.pautando.features.log_out.data.datasource.local;

import com.uds.pautando.core.preferences.MyPreferences;

public class LogOutLocalDataSourceImpl implements LogOutLocalDataSource {
    MyPreferences myPreferences = MyPreferences.getInstance();
    @Override
    public void logOut() {
        myPreferences.deleteUserData();
    }
}

package com.uds.pautando.features.login.data.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;

public interface LoginRemoteDataSource {
    MutableLiveData<LoginResponse> login(Login login);
}

package com.uds.pautando.features.login.data.datasource.remote;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.data.model.User;

public interface LoginRemoteDataSource {
    MutableLiveData<LoginResponse> login(Login login, SuccessFailureCallback<User> callback);
}

package com.uds.pautando.features.sign_in.data.datasource.remote;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.model.Login;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;

public interface SignInRemoteDataSource {
    MutableLiveData<LoginResponse> login(Login login, SuccessFailureCallback<SignInUser> callback);
}

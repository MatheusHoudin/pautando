package com.uds.pautando.features.sign_in.data.datasource.remote;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.model.SignIn;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;

public interface SignInRemoteDataSource {
    MutableLiveData<SignInResponse> login(SignIn signIn, SuccessFailureCallback<SignInUser> callback);
}

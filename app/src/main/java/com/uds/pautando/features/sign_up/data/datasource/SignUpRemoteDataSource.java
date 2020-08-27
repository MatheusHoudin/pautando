package com.uds.pautando.features.sign_up.data.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;

public interface SignUpRemoteDataSource {
    MutableLiveData<SignUpResponse> signUp(SignUpUser signUpUser);
}

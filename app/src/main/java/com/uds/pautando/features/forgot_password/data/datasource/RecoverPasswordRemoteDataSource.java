package com.uds.pautando.features.forgot_password.data.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.data.model.UserEmail;

public interface RecoverPasswordRemoteDataSource {
    MutableLiveData<RecoverPasswordResponse> recoverPassword(UserEmail userEmail);
}

package com.uds.pautando.features.forgot_password.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.data.model.UserEmail;

public interface RecoverPasswordRepository {
    MutableLiveData<RecoverPasswordResponse> recoverPassword(UserEmail userEmail);
}

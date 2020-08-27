package com.uds.pautando.features.sign_in.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.sign_in.data.model.Login;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;

public interface SignInRepository {
    MutableLiveData<LoginResponse> login(Login login);
}

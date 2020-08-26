package com.uds.pautando.features.login.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;

public interface LoginRepository {
    MutableLiveData<LoginResponse> login(Login login);
}

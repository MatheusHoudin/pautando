package com.uds.pautando.features.login.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.domain.usecase.LoginParams;
import com.uds.pautando.features.login.domain.usecase.LoginUseCase;

public class LoginViewModel extends ViewModel {
    private LoginUseCase loginUseCase = new LoginUseCase();

    public MutableLiveData<LoginResponse> login(String email, String password) {
        return loginUseCase.call(new LoginParams(email,password));
    }
}

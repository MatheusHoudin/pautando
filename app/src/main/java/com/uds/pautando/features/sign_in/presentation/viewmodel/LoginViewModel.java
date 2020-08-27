package com.uds.pautando.features.sign_in.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.domain.usecase.SignInParams;
import com.uds.pautando.features.sign_in.domain.usecase.SignInUseCase;

public class LoginViewModel extends ViewModel {
    private SignInUseCase signInUseCase = new SignInUseCase();

    public MutableLiveData<LoginResponse> login(String email, String password) {
        return signInUseCase.call(new SignInParams(email,password));
    }
}

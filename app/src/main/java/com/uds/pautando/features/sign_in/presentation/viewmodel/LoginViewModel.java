package com.uds.pautando.features.sign_in.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.factory.UseCaseFactory;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.domain.usecase.SignInParams;
import com.uds.pautando.features.sign_in.domain.usecase.SignInUseCase;

public class LoginViewModel extends ViewModel {
    private SignInUseCase signInUseCase;

    public LoginViewModel() {
        signInUseCase = UseCaseFactory.getSignInUseCase();
    }

    public MutableLiveData<SignInResponse> login(String email, String password) {
        return signInUseCase.call(new SignInParams(email,password));
    }
}

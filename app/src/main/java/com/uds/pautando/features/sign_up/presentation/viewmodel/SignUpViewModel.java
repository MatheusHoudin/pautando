package com.uds.pautando.features.sign_up.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.domain.usecase.SignUpParams;
import com.uds.pautando.features.sign_up.domain.usecase.SignUpUseCase;

public class SignUpViewModel extends ViewModel {
    private SignUpUseCase signUpUseCase = new SignUpUseCase();

    public MutableLiveData<SignUpResponse> signUp(String name, String email, String password) {
        return signUpUseCase.call(new SignUpParams(name,email,password));
    }
}

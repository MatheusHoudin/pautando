package com.uds.pautando.features.forgot_password.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.domain.usecase.RecoverPasswordParams;
import com.uds.pautando.features.forgot_password.domain.usecase.RecoverPasswordUseCase;

public class ForgotPasswordViewModel extends ViewModel {
    private RecoverPasswordUseCase useCase = new RecoverPasswordUseCase();

    public MutableLiveData<RecoverPasswordResponse> recoverPassword(String email) {
        return useCase.call(new RecoverPasswordParams(email));
    }
}

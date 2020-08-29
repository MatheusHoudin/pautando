package com.uds.pautando.features.log_out.domain.viewmodel;

import androidx.lifecycle.ViewModel;

import com.uds.pautando.features.log_out.domain.usecase.LogOutUseCase;

public class LogOutViewModel extends ViewModel {
    private LogOutUseCase useCase = new LogOutUseCase();

    public void logOut(){
        useCase.call(null);
    }
}

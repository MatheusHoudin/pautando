package com.uds.pautando.features.sign_in.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.domain.usecase.GetCurrentUserUseCase;

public class CurrentUserViewModel extends ViewModel {
    private GetCurrentUserUseCase userUseCase;
    private MutableLiveData<SignInUser> userMutableLiveData;

    public CurrentUserViewModel(){
        userUseCase = new GetCurrentUserUseCase();
        userMutableLiveData = new MutableLiveData<>();
    }

    public void init(){
        SignInUser user = userUseCase.call(null);
        userMutableLiveData.postValue(user);
    }

    public MutableLiveData<SignInUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}

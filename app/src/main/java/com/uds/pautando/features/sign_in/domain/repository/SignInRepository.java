package com.uds.pautando.features.sign_in.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.sign_in.data.model.SignIn;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;

public interface SignInRepository {
    MutableLiveData<SignInResponse> signIn(SignIn signIn);
    SignInUser getCurrentUser();
}

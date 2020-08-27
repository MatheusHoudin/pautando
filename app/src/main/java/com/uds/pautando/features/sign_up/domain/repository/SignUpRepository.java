package com.uds.pautando.features.sign_up.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;

public interface SignUpRepository {
    MutableLiveData<SignUpResponse> signUp(SignUpUser signUpUser);
}

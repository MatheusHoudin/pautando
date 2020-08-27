package com.uds.pautando.features.sign_up.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.sign_up.data.datasource.SignUpRemoteDataSource;
import com.uds.pautando.features.sign_up.data.datasource.SignUpRemoteDataSourceImpl;
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;
import com.uds.pautando.features.sign_up.domain.repository.SignUpRepository;

public class SignUpRepositoryImpl implements SignUpRepository {
    private SignUpRemoteDataSource signUpRemoteDataSource = new SignUpRemoteDataSourceImpl();
    @Override
    public MutableLiveData<SignUpResponse> signUp(SignUpUser signUpUser) {
        return signUpRemoteDataSource.signUp(signUpUser);
    }
}

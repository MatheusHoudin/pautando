package com.uds.pautando.features.login.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.login.data.datasource.LoginRemoteDataSource;
import com.uds.pautando.features.login.data.datasource.LoginRemoteDataSourceImpl;
import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.domain.repository.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository {
    LoginRemoteDataSource loginRemoteDataSource = new LoginRemoteDataSourceImpl();

    @Override
    public MutableLiveData<LoginResponse> login(Login login) {
        return loginRemoteDataSource.login(login);
    }
}

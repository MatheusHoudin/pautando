package com.uds.pautando.features.login.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.login.data.datasource.local.LoginLocalDataSource;
import com.uds.pautando.features.login.data.datasource.local.LoginLocalDataSourceImpl;
import com.uds.pautando.features.login.data.datasource.remote.LoginRemoteDataSource;
import com.uds.pautando.features.login.data.datasource.remote.LoginRemoteDataSourceImpl;
import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.data.model.User;
import com.uds.pautando.features.login.domain.repository.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository {
    LoginRemoteDataSource loginRemoteDataSource = new LoginRemoteDataSourceImpl();
    LoginLocalDataSource loginLocalDataSource = new LoginLocalDataSourceImpl();

    @Override
    public MutableLiveData<LoginResponse> login(Login login) {
        return loginRemoteDataSource.login(login, new SuccessFailureCallback<User>() {
            @Override
            public void onSuccess(User result) {
                loginLocalDataSource.saveLoginData(result.getUid(),result.getEmail());
            }

            @Override
            public void onFailure(String message) {
                Log.i("LoginRepositoryImpl","message");
            }
        });
    }
}

package com.uds.pautando.features.sign_in.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.datasource.local.LoginLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.LoginLocalDataSourceImpl;
import com.uds.pautando.features.sign_in.data.datasource.remote.LoginRemoteDataSource;
import com.uds.pautando.features.sign_in.data.datasource.remote.LoginRemoteDataSourceImpl;
import com.uds.pautando.features.sign_in.data.model.Login;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.data.model.User;
import com.uds.pautando.features.sign_in.domain.repository.LoginRepository;

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

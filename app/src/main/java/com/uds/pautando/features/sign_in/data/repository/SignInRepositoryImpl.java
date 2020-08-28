package com.uds.pautando.features.sign_in.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;
import com.uds.pautando.features.sign_in.data.datasource.remote.SignInRemoteDataSource;
import com.uds.pautando.features.sign_in.data.datasource.remote.signInRemoteDataSourceImpl;
import com.uds.pautando.features.sign_in.data.model.SignIn;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.domain.repository.SignInRepository;

public class SignInRepositoryImpl implements SignInRepository {
    SignInRemoteDataSource signInRemoteDataSource = new signInRemoteDataSourceImpl();
    SignInLocalDataSource signInLocalDataSource = new SignInLocalDataSourceImpl();

    @Override
    public MutableLiveData<SignInResponse> signIn(SignIn signIn) {
        return signInRemoteDataSource.login(signIn, new SuccessFailureCallback<SignInUser>() {
            @Override
            public void onSuccess(SignInUser result) {
                signInLocalDataSource.saveUserData(result.getUid(),result.getName(),result.getEmail());
            }

            @Override
            public void onFailure(String message) {
                Log.i("LoginRepositoryImpl","message");
            }
        });
    }

    @Override
    public SignInUser getCurrentUser() {
        return signInLocalDataSource.getCurrentUser();
    }
}

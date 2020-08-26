package com.uds.pautando.features.login.data.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;

public class LoginRemoteDataSourceImpl implements LoginRemoteDataSource {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public MutableLiveData<LoginResponse> login(Login login) {
        final MutableLiveData<LoginResponse> loginResponseMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(
                login.getEmail().getValue(),
                login.getPassword().getValue()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    loginResponseMutableLiveData.postValue(
                      new LoginResponse(true,null)
                    );
                }else{
                    loginResponseMutableLiveData.postValue(
                      new LoginResponse(false,task.getException().toString())
                    );
                    Log.i("LOGIN EXCEPTION",task.getException().toString());
                }
            }
        });
        return loginResponseMutableLiveData;
    }
}

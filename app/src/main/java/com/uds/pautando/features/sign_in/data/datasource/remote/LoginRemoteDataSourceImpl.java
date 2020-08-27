package com.uds.pautando.features.sign_in.data.datasource.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.model.Login;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.data.model.User;

public class LoginRemoteDataSourceImpl implements LoginRemoteDataSource {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public MutableLiveData<LoginResponse> login(Login login, final SuccessFailureCallback<User> callback) {
        final MutableLiveData<LoginResponse> loginResponseMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(
                login.getEmail().getValue(),
                login.getPassword().getValue()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    callback.onSuccess(new User(
                      firebaseUser.getUid(),
                      firebaseUser.getEmail(),
                      null
                    ));
                    loginResponseMutableLiveData.postValue(
                      new LoginResponse(true,null)
                    );
                }else{
                    callback.onFailure(task.getException().toString());
                    if(task.getException() instanceof FirebaseAuthInvalidUserException) {
                        loginResponseMutableLiveData.postValue(
                          new LoginResponse(
                            "O usuário fornecido não está cadastrado, por favor crie sua conta", null,
                            false,false,true,false,false,false
                          )
                        );
                    }else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        loginResponseMutableLiveData.postValue(
                          new LoginResponse(
                            null, "A senha que você digitou não está correta, por favor tente novamente",
                            false,false,false,true,false,false
                          )
                        );
                    }else{
                        Log.i("UNEXPECTED", "DJASDBÇAKSJDA");
                        loginResponseMutableLiveData.postValue(
                          new LoginResponse(
                            null, null, "Ocorreu um erro inesperado ao buscar seu usuário, por favor tente novamente",
                            false,false,false,false,true,false
                          )
                        );
                    }

                    Log.i("LOGIN EXCEPTION",task.getException().toString());
                }
            }
        });
        return loginResponseMutableLiveData;
    }
}

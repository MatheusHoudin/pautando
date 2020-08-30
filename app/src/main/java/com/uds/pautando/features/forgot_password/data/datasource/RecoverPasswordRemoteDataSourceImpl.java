package com.uds.pautando.features.forgot_password.data.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.uds.pautando.factory.FirebaseFactory;
import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.data.model.UserEmail;

public class RecoverPasswordRemoteDataSourceImpl implements RecoverPasswordRemoteDataSource {
    FirebaseAuth firebaseAuth;

    public RecoverPasswordRemoteDataSourceImpl() {
        firebaseAuth = FirebaseFactory.getFirebaseAuth();
    }
    @Override
    public MutableLiveData<RecoverPasswordResponse> recoverPassword(UserEmail userEmail) {
        final MutableLiveData<RecoverPasswordResponse> mutableLiveData = new MutableLiveData<>();
        firebaseAuth.sendPasswordResetEmail(userEmail.getEmail().getValue())
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    mutableLiveData.postValue(new RecoverPasswordResponse(
                      true,false,false,false,
                      false, null,null
                    ));
                }else{
                    if(task.getException() instanceof FirebaseAuthInvalidUserException) {
                        mutableLiveData.postValue(new RecoverPasswordResponse(
                          false,false,false,false,
                          true, "O email fornecido não está cadastrado",null
                        ));
                    }else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        mutableLiveData.postValue(new RecoverPasswordResponse(
                          false,false,true,false,
                          false, "O email fornecido não é válido, tente algo como uds@pautando.com",null
                        ));
                    }else{
                        mutableLiveData.postValue(new RecoverPasswordResponse(
                          false,false,true,true,
                          false, null,"Ocorreu um erro ao tentar enviar o email de recuperação, por favor tente novamente"
                        ));
                    }
                }
            }
        });
        return mutableLiveData;
    }
}

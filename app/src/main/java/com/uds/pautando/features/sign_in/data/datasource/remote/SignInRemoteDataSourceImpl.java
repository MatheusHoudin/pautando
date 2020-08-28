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
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.uds.pautando.core.callback.SuccessFailureCallback;
import com.uds.pautando.features.sign_in.data.model.SignIn;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;

import javax.annotation.Nullable;

public class SignInRemoteDataSourceImpl implements SignInRemoteDataSource {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    public MutableLiveData<SignInResponse> login(SignIn signIn, final SuccessFailureCallback<SignInUser> callback) {
        final MutableLiveData<SignInResponse> loginResponseMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(
                signIn.getEmail().getValue(),
                signIn.getPassword().getValue()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    firestore.collection("users").whereEqualTo("uid",firebaseUser.getUid())
                      .addSnapshotListener(new EventListener<QuerySnapshot>() {
                          @Override
                          public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                              callback.onSuccess(new SignInUser(
                                firebaseUser.getUid(),
                                firebaseUser.getEmail(),
                                queryDocumentSnapshots.getDocuments().get(0).getString("name")
                              ));
                              loginResponseMutableLiveData.postValue(
                                      new SignInResponse(true,null)
                              );
                          }
                      });
                }else{
                    callback.onFailure(task.getException().toString());
                    if(task.getException() instanceof FirebaseAuthInvalidUserException) {
                        loginResponseMutableLiveData.postValue(
                          new SignInResponse(
                            "O usuário fornecido não está cadastrado, por favor crie sua conta", null,
                            false,false,true,false,false,false
                          )
                        );
                    }else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        loginResponseMutableLiveData.postValue(
                          new SignInResponse(
                            null, "A senha que você digitou não está correta, por favor tente novamente",
                            false,false,false,true,false,false
                          )
                        );
                    }else{
                        loginResponseMutableLiveData.postValue(
                          new SignInResponse(
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

package com.uds.pautando.features.sign_up.data.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.core.models.User;
import com.uds.pautando.factory.FirebaseFactory;
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;

import java.util.ArrayList;

public class SignUpRemoteDataSourceImpl implements SignUpRemoteDataSource{
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;

    public SignUpRemoteDataSourceImpl(){
        firebaseAuth = FirebaseFactory.getFirebaseAuth();
        firestore = FirebaseFactory.getFirebaseFirestore();
    }

    @Override
    public MutableLiveData<SignUpResponse> signUp(final SignUpUser signUpUser) {
        final MutableLiveData<SignUpResponse> signUpResponseMutableLiveData = new MutableLiveData<>();
        firebaseAuth.createUserWithEmailAndPassword(signUpUser.getEmail().getValue(),signUpUser.getPassword().getValue())
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    firestore.collection("users").add(new User(
                      firebaseUser.getUid(),
                      signUpUser.getName().getValue(),
                      signUpUser.getEmail().getValue(),
                      new ArrayList<MeetingAgenda>()
                    ))
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> firestoreTask) {
                            if(firestoreTask.isSuccessful()) {
                                signUpResponseMutableLiveData.postValue(new SignUpResponse(
                                  true,
                                  null
                                ));
                            }else{
                                firebaseUser.delete();
                                signUpResponseMutableLiveData.postValue(new SignUpResponse(
                                  false,
                                  "Ocorreu um erro ao criar sua conta, por favor tente novamente"
                                ));
                            }
                        }
                    });
                }else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                        signUpResponseMutableLiveData.postValue(new SignUpResponse(
                          false, false, false, false, false, false, false, false, false, false ,false,
                          true, "O email fornecido já está em uso, por favor tente outro ou recupere sua senha",null, null, null
                        ));
                    }else{
                        signUpResponseMutableLiveData.postValue(new SignUpResponse(
                          false, false, false, false, false, false, false, false, false, false ,true,
                          false, null, null,null, "Ocorreu um erro inesperado ao criar sua conta, por favor tente novamente"
                        ));
                    }
                }
            }
        });
        return signUpResponseMutableLiveData;
    }
}

package com.uds.pautando.features.log_out.data.datasource.remote;

import com.google.firebase.auth.FirebaseAuth;
import com.uds.pautando.factory.FirebaseFactory;

public class LogOutRemoteDataSourceImpl implements LogOutRemoteDataSource{
    FirebaseAuth auth;

    public LogOutRemoteDataSourceImpl() {
        auth = FirebaseFactory.getFirebaseAuth();
    }
    @Override
    public void logOut() {
        auth.signOut();
    }
}

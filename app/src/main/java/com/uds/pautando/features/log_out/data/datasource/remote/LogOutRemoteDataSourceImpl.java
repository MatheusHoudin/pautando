package com.uds.pautando.features.log_out.data.datasource.remote;

import com.google.firebase.auth.FirebaseAuth;

public class LogOutRemoteDataSourceImpl implements LogOutRemoteDataSource{
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    public void logOut() {
        auth.signOut();
    }
}

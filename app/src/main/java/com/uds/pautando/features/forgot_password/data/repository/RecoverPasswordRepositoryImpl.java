package com.uds.pautando.features.forgot_password.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.factory.DataSourceFactory;
import com.uds.pautando.features.forgot_password.data.datasource.RecoverPasswordRemoteDataSource;
import com.uds.pautando.features.forgot_password.data.datasource.RecoverPasswordRemoteDataSourceImpl;
import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.data.model.UserEmail;
import com.uds.pautando.features.forgot_password.domain.repository.RecoverPasswordRepository;

public class RecoverPasswordRepositoryImpl implements RecoverPasswordRepository {
    private RecoverPasswordRemoteDataSource dataSource;

    public RecoverPasswordRepositoryImpl() {
        dataSource = DataSourceFactory.getRecoverPasswordRemoteDataSource();
    }

    @Override
    public MutableLiveData<RecoverPasswordResponse> recoverPassword(UserEmail userEmail) {
        return dataSource.recoverPassword(userEmail);
    }
}

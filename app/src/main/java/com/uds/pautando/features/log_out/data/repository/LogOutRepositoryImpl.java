package com.uds.pautando.features.log_out.data.repository;

import com.uds.pautando.factory.DataSourceFactory;
import com.uds.pautando.features.log_out.data.datasource.local.LogOutLocalDataSource;
import com.uds.pautando.features.log_out.data.datasource.local.LogOutLocalDataSourceImpl;
import com.uds.pautando.features.log_out.data.datasource.remote.LogOutRemoteDataSource;
import com.uds.pautando.features.log_out.data.datasource.remote.LogOutRemoteDataSourceImpl;
import com.uds.pautando.features.log_out.domain.repository.LogOutRepository;

public class LogOutRepositoryImpl implements LogOutRepository {
    private LogOutRemoteDataSource remoteDataSource;
    private LogOutLocalDataSource localDataSource;

    public LogOutRepositoryImpl() {
        remoteDataSource = DataSourceFactory.getLogOutRemoteDataSource();
        localDataSource = DataSourceFactory.getLogOutLocalDataSource();
    }

    @Override
    public void logOut() {
        remoteDataSource.logOut();
        localDataSource.logOut();
    }
}

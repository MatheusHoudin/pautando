package com.uds.pautando.features.log_out.domain.usecase;

import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.factory.RepositoryFactory;
import com.uds.pautando.features.log_out.data.repository.LogOutRepositoryImpl;
import com.uds.pautando.features.log_out.domain.repository.LogOutRepository;

public class LogOutUseCase implements BaseUseCase<Void, Void> {
    private LogOutRepository repository;

    public LogOutUseCase() {
        repository = RepositoryFactory.getLogOutRepository();
    }

    @Override
    public Void call(Void aVoid) {
        repository.logOut();
        return null;
    }
}

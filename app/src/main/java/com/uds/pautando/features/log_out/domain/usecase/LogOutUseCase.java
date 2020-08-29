package com.uds.pautando.features.log_out.domain.usecase;

import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.features.log_out.data.datasource.repository.LogOutRepositoryImpl;
import com.uds.pautando.features.log_out.domain.repository.LogOutRepository;

public class LogOutUseCase implements BaseUseCase<Void, Void> {
    private LogOutRepository repository = new LogOutRepositoryImpl();

    @Override
    public Void call(Void aVoid) {
        repository.logOut();
        return null;
    }
}

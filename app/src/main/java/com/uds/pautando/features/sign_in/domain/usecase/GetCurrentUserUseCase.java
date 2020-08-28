package com.uds.pautando.features.sign_in.domain.usecase;

import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.data.repository.SignInRepositoryImpl;
import com.uds.pautando.features.sign_in.domain.repository.SignInRepository;

public class GetCurrentUserUseCase implements BaseUseCase<SignInUser,Void> {
    private SignInRepository repository = new SignInRepositoryImpl();
    @Override
    public SignInUser call(Void aVoid) {
        return repository.getCurrentUser();
    }
}

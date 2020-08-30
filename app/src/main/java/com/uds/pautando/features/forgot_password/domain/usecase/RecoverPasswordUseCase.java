package com.uds.pautando.features.forgot_password.domain.usecase;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.InvalidEmailFormatException;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.factory.RepositoryFactory;
import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.data.model.UserEmail;
import com.uds.pautando.features.forgot_password.data.repository.RecoverPasswordRepositoryImpl;
import com.uds.pautando.features.forgot_password.domain.repository.RecoverPasswordRepository;

public class RecoverPasswordUseCase implements BaseUseCase<MutableLiveData<RecoverPasswordResponse>, RecoverPasswordParams> {
    private RecoverPasswordRepository repository;

    public RecoverPasswordUseCase() {
        repository = RepositoryFactory.getRecoverPasswordRepository();
    }

    @Override
    public MutableLiveData<RecoverPasswordResponse> call(RecoverPasswordParams recoverPasswordParams) {
        MutableLiveData<RecoverPasswordResponse> mutableLiveData = new MutableLiveData<>();
        try {
            UserEmail userEmail = new UserEmail(recoverPasswordParams.getEmail());
            return repository.recoverPassword(userEmail);
        } catch (EmptyEmailException e) {
            mutableLiveData.postValue(new RecoverPasswordResponse(
              false,true,false,false,
              true, e.getMessage(),null
            ));
        } catch (InvalidEmailFormatException e) {
            mutableLiveData.postValue(new RecoverPasswordResponse(
              false,false,true,false,
              true, e.getMessage(),null
            ));
        } catch (Exception e) {
            mutableLiveData.postValue(new RecoverPasswordResponse(
              false,false,true,true,
              false, null,e.getMessage()
            ));
        }
        return mutableLiveData;
    }
}

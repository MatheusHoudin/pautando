package com.uds.pautando.features.sign_in.domain.usecase;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.core.error.exception.InvalidEmailFormatException;
import com.uds.pautando.core.error.exception.ShortPasswordException;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.features.sign_in.data.model.Login;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.data.repository.SignInRepositoryImpl;
import com.uds.pautando.features.sign_in.domain.repository.SignInRepository;

public class SignInUseCase implements BaseUseCase<MutableLiveData<LoginResponse>, SignInParams> {
    private SignInRepository repository = new SignInRepositoryImpl();
    @Override
    public MutableLiveData<LoginResponse> call(SignInParams params) {
        MutableLiveData<LoginResponse> loginResult = new MutableLiveData<>();
        try {
            Login login = new Login(params.getEmail(),params.getPassword());
            return repository.login(login);
        } catch (EmailAndPasswordNotProvidedException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
              e.getMessage(),
              true,false,false,false,false,false
            ));
        } catch (EmptyEmailException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             null,
             false,true,false,false,false,false
            ));
        } catch (EmptyPasswordException e) {
            loginResult.postValue(new LoginResponse(
              null,
               e.getMessage(),
             false,false,false,false,false,true
            ));
        } catch (InvalidEmailFormatException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             null,
             false,false,true,false,false,false
            ));
        } catch (ShortPasswordException e) {
            loginResult.postValue(new LoginResponse(
              null,
              e.getMessage(),
             false,false,false,true,false,false
            ));
        } catch (Exception e) {
            loginResult.postValue(new LoginResponse(
              null,
             null,
             false,false,false,false,true,false
            ));
        }
        return loginResult;
    }
}



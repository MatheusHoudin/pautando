package com.uds.pautando.features.login.domain.usecase;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.core.error.exception.InvalidEmailFormatException;
import com.uds.pautando.core.error.exception.ShortPasswordException;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.features.login.data.model.Login;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.data.repository.LoginRepositoryImpl;
import com.uds.pautando.features.login.domain.repository.LoginRepository;

public class LoginUseCase implements BaseUseCase<MutableLiveData<LoginResponse>, LoginParams> {
    private LoginRepository repository = new LoginRepositoryImpl();
    @Override
    public MutableLiveData<LoginResponse> call(LoginParams params) {
        MutableLiveData<LoginResponse> loginResult = new MutableLiveData<>();
        try {
            Login login = new Login(params.getEmail(),params.getPassword());
            return repository.login(login);
        } catch (EmailAndPasswordNotProvidedException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
              true,false,false,false,false,false
            ));
        } catch (EmptyEmailException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             false,true,false,false,false,false
            ));
        } catch (EmptyPasswordException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             false,false,false,false,false,true
            ));
        } catch (InvalidEmailFormatException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             false,false,true,false,false,false
            ));
        } catch (ShortPasswordException e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             false,false,false,true,false,false
            ));
        } catch (Exception e) {
            loginResult.postValue(new LoginResponse(
              e.getMessage(),
             false,false,false,false,true,false
            ));
        }
        return loginResult;
    }
}



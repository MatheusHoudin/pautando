package com.uds.pautando.features.sign_up.domain.usecase;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.error.exception.EmailAndNameNotProvidedException;
import com.uds.pautando.core.error.exception.EmailAndPasswordAndNameNotProvidedException;
import com.uds.pautando.core.error.exception.EmailAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyEmailException;
import com.uds.pautando.core.error.exception.EmptyNameException;
import com.uds.pautando.core.error.exception.EmptyPasswordException;
import com.uds.pautando.core.error.exception.InvalidEmailFormatException;
import com.uds.pautando.core.error.exception.NameAndPasswordNotProvidedException;
import com.uds.pautando.core.error.exception.ShortPasswordException;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.factory.RepositoryFactory;
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;
import com.uds.pautando.features.sign_up.data.repository.SignUpRepositoryImpl;
import com.uds.pautando.features.sign_up.domain.repository.SignUpRepository;

public class SignUpUseCase implements BaseUseCase<MutableLiveData<SignUpResponse>, SignUpParams> {
    private SignUpRepository repository;

    public SignUpUseCase() {
        repository = RepositoryFactory.getSignUpRepository();
    }

    @Override
    public MutableLiveData<SignUpResponse> call(SignUpParams signUpParams) {
        MutableLiveData<SignUpResponse> mutableLiveData = new MutableLiveData<>();
        try {
            SignUpUser signUpUser = new SignUpUser(signUpParams.getName(),signUpParams.getEmail(),signUpParams.getPassword());
            return repository.signUp(signUpUser);
        } catch (EmailAndPasswordAndNameNotProvidedException e) {
            Log.i("RESULT","EmailAndPasswordAndNameNotProvidedException");
            mutableLiveData.postValue(new SignUpResponse(
              false, true, false,
              false, false, false, false,
              false, false, false ,false,
              false, e.getMessage(), e.getMessage(), e.getMessage(), null
            ));
        } catch (EmailAndNameNotProvidedException e) {
            Log.i("RESULT","EmailAndNameNotProvidedException");
            mutableLiveData.postValue(new SignUpResponse(
               false, false, false,
               true, false, false, false,
               false, false, false ,false,
               false, e.getMessage(), null, e.getMessage(), null
            ));
        } catch (EmailAndPasswordNotProvidedException e) {
            Log.i("RESULT","EmailAndPasswordNotProvidedException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, true,
              false, false, false, false,
              false, false, false ,false,
              false, e.getMessage(), e.getMessage(), null, null
            ));
        } catch (NameAndPasswordNotProvidedException e) {
            Log.i("RESULT","NameAndPasswordNotProvidedException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, true, false, false,
              false, false, false ,false,
              false, null, e.getMessage(), e.getMessage(), null
            ));
        } catch (EmptyEmailException e) {
            Log.i("RESULT","EmptyEmailException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, true, false,
              false, false, false ,false,
              false, e.getMessage(), null, null, null
            ));
        } catch (EmptyNameException e) {
            Log.i("RESULT","EmptyNameException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              true, false, false ,false,
              false, null, null, e.getMessage(), null
            ));
        } catch (EmptyPasswordException e) {
            Log.i("RESULT","EmptyPasswordException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, true,
              false, false, false ,false,
              false, null, e.getMessage(), null, null
            ));
        } catch (InvalidEmailFormatException e) {
            Log.i("RESULT","InvalidEmailFormatException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, true, false ,false,
              false, e.getMessage(), null, null, null
            ));
        } catch (ShortPasswordException e) {
            Log.i("RESULT","ShortPasswordException");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, false, true ,false,
              false, null, e.getMessage(), null, null
            ));
        } catch (Exception e) {
            Log.i("RESULT","Exception");

            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, false, false ,true,
              false, null, null, null, e.getMessage()
            ));
        }

        return mutableLiveData;
    }
}

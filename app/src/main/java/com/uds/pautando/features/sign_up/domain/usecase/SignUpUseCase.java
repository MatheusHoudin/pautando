package com.uds.pautando.features.sign_up.domain.usecase;

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
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.data.model.SignUpUser;
import com.uds.pautando.features.sign_up.data.repository.SignUpRepositoryImpl;
import com.uds.pautando.features.sign_up.domain.repository.SignUpRepository;

public class SignUpUseCase implements BaseUseCase<MutableLiveData<SignUpResponse>, SignUpParams> {
    private SignUpRepository repository = new SignUpRepositoryImpl();

    @Override
    public MutableLiveData<SignUpResponse> call(SignUpParams signUpParams) {
        MutableLiveData<SignUpResponse> mutableLiveData = new MutableLiveData<>();
        try {
            SignUpUser signUpUser = new SignUpUser(signUpParams.getName(),signUpParams.getEmail(),signUpParams.getPassword());
        } catch (EmailAndPasswordAndNameNotProvidedException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, true, true,
              false, false, false, false,
              false, false, false ,false,
              false, e.getMessage(), e.getMessage(), e.getMessage(), null
            ));
        } catch (EmailAndNameNotProvidedException e) {
            mutableLiveData.postValue(new SignUpResponse(
               false, false, false,
               true, false, false, false,
               false, false, false ,false,
               false, e.getMessage(), null, e.getMessage(), null
            ));
        } catch (EmailAndPasswordNotProvidedException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, true,
              false, false, false, false,
              false, false, false ,false,
              false, e.getMessage(), e.getMessage(), null, null
            ));
        } catch (NameAndPasswordNotProvidedException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, true, false, false,
              false, false, false ,false,
              false, null, e.getMessage(), e.getMessage(), null
            ));
        } catch (EmptyEmailException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, true, false,
              false, false, false ,false,
              false, e.getMessage(), null, null, null
            ));
        } catch (EmptyNameException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              true, false, false ,false,
              false, null, null, e.getMessage(), null
            ));
        } catch (EmptyPasswordException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, true,
              false, false, false ,false,
              false, null, e.getMessage(), null, null
            ));
        } catch (InvalidEmailFormatException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, true, false ,false,
              false, e.getMessage(), null, null, null
            ));
        } catch (ShortPasswordException e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, false, true ,false,
              false, null, e.getMessage(), null, null
            ));
        } catch (Exception e) {
            mutableLiveData.postValue(new SignUpResponse(
              false, false, false,
              false, false, false, false,
              false, false, false ,true,
              false, null, e.getMessage(), null, null
            ));
        }

        return mutableLiveData;
    }
}

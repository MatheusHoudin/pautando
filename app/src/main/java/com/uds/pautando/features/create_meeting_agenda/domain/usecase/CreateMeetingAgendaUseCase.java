package com.uds.pautando.features.create_meeting_agenda.domain.usecase;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.error.exception.DescriptionAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.DescriptionAndDetailsAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.DescriptionAndDetailsNotProvidedException;
import com.uds.pautando.core.error.exception.EmptyAuthorException;
import com.uds.pautando.core.error.exception.EmptyDescriptionException;
import com.uds.pautando.core.error.exception.EmptyDetailsException;
import com.uds.pautando.core.error.exception.EmptyTitleException;
import com.uds.pautando.core.error.exception.TitleAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndDetailsAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndDetailsNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDetailsNotProvidedException;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.factory.RepositoryFactory;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;
import com.uds.pautando.features.create_meeting_agenda.data.repository.CreateMeetingAgendaRepositoryImpl;
import com.uds.pautando.features.create_meeting_agenda.domain.repository.CreateMeetingAgendaRepository;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;
import com.uds.pautando.features.sign_in.domain.repository.SignInRepository;

public class CreateMeetingAgendaUseCase implements BaseUseCase<MutableLiveData<CreateMeetingAgendaResponse>, CreateMeetingAgendaParams> {
    private CreateMeetingAgendaRepository repository = new CreateMeetingAgendaRepositoryImpl();
    private SignInRepository signInRepository;

    public CreateMeetingAgendaUseCase() {
        repository = RepositoryFactory.getCreateMeetingAgendaRepository();
        signInRepository = RepositoryFactory.getSignInRepository();
    }

    @Override
    public MutableLiveData<CreateMeetingAgendaResponse> call(CreateMeetingAgendaParams createMeetingAgendaParams) {
        MutableLiveData<CreateMeetingAgendaResponse> mutableLiveData = new MutableLiveData<>();
        try {
            MeetingAgenda meetingAgenda = new MeetingAgenda(
              createMeetingAgendaParams.getTitle(),
              createMeetingAgendaParams.getDescription(),
              createMeetingAgendaParams.getDetails(),
              signInRepository.getCurrentUser().getName()
            );

            return repository.createMeeting(meetingAgenda);
        } catch (TitleAndDescriptionAndDetailsAndAuthorNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              true, false, false, false, false, false, false, false, false, e.getMessage(), e.getMessage(),
               e.getMessage(), e.getMessage(), null
            ));
        } catch (DescriptionAndAuthorNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, true, false, false,
              false, false, false, false, false, false, false, false, false, null, e.getMessage(),
              null, e.getMessage(), null
            ));
        } catch (DescriptionAndDetailsAndAuthorNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, true, false, false, false, false,
              false, false, false, false, false, false, false, false, false, null, e.getMessage(),
              e.getMessage(), e.getMessage(), null
            ));
        } catch (DescriptionAndDetailsNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, true, false, false, false,
              false, false, false, false, false, false, false, false, false, null, e.getMessage(),
              e.getMessage(), null, null
            ));
        } catch (TitleAndAuthorNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, true, false,
              false, false, false, false, false, false, false, false, false, e.getMessage(), null,
              null, e.getMessage(), null
            ));
        } catch (TitleAndDescriptionAndAuthorNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, true,
              false, false, false, false, false, false, false, false, false, e.getMessage(), e.getMessage(),
              null, e.getMessage(), null
            ));
        } catch (TitleAndDescriptionAndDetailsNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, true, false, false, false, false, false, false, false, e.getMessage(), e.getMessage(),
              e.getMessage(), null, null
            ));
        } catch (TitleAndDescriptionNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, true, false, false, false, false, false, false, e.getMessage(), e.getMessage(),
              null, null, null
            ));
        } catch (TitleAndDetailsNotProvidedException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, true, false, false, false, false, false, e.getMessage(), null,
              e.getMessage(), null, null
            ));
        } catch (EmptyTitleException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, false, true, false, false, false, false, e.getMessage(), null,
              null, null, null
            ));
        } catch (EmptyDescriptionException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, false, false, true, false, false, false, null, e.getMessage(),
              null, null, null
            ));
        } catch (EmptyDetailsException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, false, false, false, true, false, false, null, null,
              e.getMessage(), null, null
            ));
        } catch (EmptyAuthorException e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, false, false, false, false, true, false, null, null,
               null, e.getMessage(), null
            ));
        } catch (Exception e) {
            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
              false, false, false, false, false, false, false,
              false, false, false, false, false, false, true, false, false, null, null,
               e.getMessage(), null, null
            ));
        }
        return mutableLiveData;
    }
}

package com.uds.pautando.features.create_meeting_agenda.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.factory.UseCaseFactory;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.domain.usecase.CreateMeetingAgendaParams;
import com.uds.pautando.features.create_meeting_agenda.domain.usecase.CreateMeetingAgendaUseCase;
import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.domain.usecase.GetCurrentUserUseCase;

public class CreateMeetingAgendaViewModel extends ViewModel {
    private CreateMeetingAgendaUseCase useCase;
    private GetCurrentUserUseCase getCurrentUserUseCase;

    public CreateMeetingAgendaViewModel() {
        useCase = UseCaseFactory.getCreateMeetingAgendaUseCase();
        getCurrentUserUseCase = UseCaseFactory.getGetCurrentUserUseCase();
    }

    public MutableLiveData<CreateMeetingAgendaResponse> createMeetingAgenda(String title, String description, String details){
        return useCase.call(new CreateMeetingAgendaParams(title,description,details));
    }

    public SignInUser getCurrentUser() {
        return getCurrentUserUseCase.call(null);
    }
}

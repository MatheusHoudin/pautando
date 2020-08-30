package com.uds.pautando.features.change_meeting_agenda_status.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;
import com.uds.pautando.features.change_meeting_agenda_status.domain.usecase.ChangeMeetingAgendaStatusParams;
import com.uds.pautando.features.change_meeting_agenda_status.domain.usecase.ChangeMeetingAgendaStatusUseCase;

public class ChangeMeetingAgendaStatusViewModel {
    private ChangeMeetingAgendaStatusUseCase useCase = new ChangeMeetingAgendaStatusUseCase();

    public MutableLiveData<ChangeMeetingAgendaResponse> changeMeetingAgendaStatus(MeetingAgenda meetingAgenda) {
        return useCase.call(new ChangeMeetingAgendaStatusParams(meetingAgenda));
    }
}

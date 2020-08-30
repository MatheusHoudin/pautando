package com.uds.pautando.features.change_meeting_agenda_status.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;

public interface ChangeMeetingAgendaStatusRepository {
    MutableLiveData<ChangeMeetingAgendaResponse> changeMeetingAgendaStatus(MeetingAgenda meetingAgenda);
}

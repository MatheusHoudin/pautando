package com.uds.pautando.features.change_meeting_agenda_status.data.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;

public interface ChangeMeetingAgendaStatusRemoteDataSource {
    MutableLiveData<ChangeMeetingAgendaResponse> changeMeeringAgendaState(MeetingAgenda meetingAgenda, String userUid);
}

package com.uds.pautando.features.create_meeting_agenda.data.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;

public interface CreateMeetingDataSource {
    MutableLiveData<CreateMeetingAgendaResponse> createMeetingAgenda(MeetingAgenda meetingAgenda);
}

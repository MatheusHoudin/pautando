package com.uds.pautando.features.create_meeting_agenda.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;

public interface CreateMeetingAgendaRepository {
    MutableLiveData<CreateMeetingAgendaResponse> createMeeting(MeetingAgenda meetingAgenda);
}

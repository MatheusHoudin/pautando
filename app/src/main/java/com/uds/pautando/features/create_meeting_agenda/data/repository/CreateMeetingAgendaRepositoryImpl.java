package com.uds.pautando.features.create_meeting_agenda.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSource;
import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSourceImpl;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;
import com.uds.pautando.features.create_meeting_agenda.domain.repository.CreateMeetingAgendaRepository;

public class CreateMeetingAgendaRepositoryImpl implements CreateMeetingAgendaRepository {
    private CreateMeetingDataSource dataSource = new CreateMeetingDataSourceImpl();
    @Override
    public MutableLiveData<CreateMeetingAgendaResponse> createMeeting(MeetingAgenda meetingAgenda) {
        return dataSource.createMeetingAgenda(meetingAgenda);
    }
}

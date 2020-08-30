package com.uds.pautando.features.create_meeting_agenda.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.factory.DataSourceFactory;
import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSource;
import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSourceImpl;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;
import com.uds.pautando.features.create_meeting_agenda.domain.repository.CreateMeetingAgendaRepository;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;

public class CreateMeetingAgendaRepositoryImpl implements CreateMeetingAgendaRepository {
    private CreateMeetingDataSource dataSource;
    private SignInLocalDataSource signInLocalDataSource;

    public CreateMeetingAgendaRepositoryImpl() {
        dataSource = DataSourceFactory.getCreateMeetingDataSource();
        signInLocalDataSource = DataSourceFactory.getSignInLocalDataSource();
    }

    @Override
    public MutableLiveData<CreateMeetingAgendaResponse> createMeeting(MeetingAgenda meetingAgenda) {
        return dataSource.createMeetingAgenda(meetingAgenda,signInLocalDataSource.getCurrentUser().getUid());
    }
}

package com.uds.pautando.features.change_meeting_agenda_status.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.factory.DataSourceFactory;
import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSource;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;
import com.uds.pautando.features.change_meeting_agenda_status.domain.repository.ChangeMeetingAgendaStatusRepository;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;

public class ChangeMeetingAgendaStatusRepositoryImpl implements ChangeMeetingAgendaStatusRepository {
    private SignInLocalDataSource signInLocalDataSource;
    private ChangeMeetingAgendaStatusRemoteDataSource remoteDataSource;

    public ChangeMeetingAgendaStatusRepositoryImpl() {
        signInLocalDataSource = DataSourceFactory.getSignInLocalDataSource();
        remoteDataSource = DataSourceFactory.getChangeMeetingAgendaStatusRemoteDataSource();
    }

    @Override
    public MutableLiveData<ChangeMeetingAgendaResponse> changeMeetingAgendaStatus(MeetingAgenda meetingAgenda) {
        return remoteDataSource.changeMeeringAgendaState(meetingAgenda, signInLocalDataSource.getCurrentUser().getUid());
    }
}

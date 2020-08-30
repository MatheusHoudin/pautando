package com.uds.pautando.features.change_meeting_agenda_status.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSource;
import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSourceImpl;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;
import com.uds.pautando.features.change_meeting_agenda_status.domain.repository.ChangeMeetingAgendaStatusRepository;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;

public class ChangeMeetingAgendaStatusRepositoryImpl implements ChangeMeetingAgendaStatusRepository {
    private SignInLocalDataSource signInLocalDataSource = new SignInLocalDataSourceImpl();
    private ChangeMeetingAgendaStatusRemoteDataSource remoteDataSource = new ChangeMeetingAgendaStatusRemoteDataSourceImpl();

    @Override
    public MutableLiveData<ChangeMeetingAgendaResponse> changeMeetingAgendaStatus(MeetingAgenda meetingAgenda) {
        return remoteDataSource.changeMeeringAgendaState(meetingAgenda, signInLocalDataSource.getCurrentUser().getUid());
    }
}

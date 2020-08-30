package com.uds.pautando.features.change_meeting_agenda_status.domain.usecase;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.factory.RepositoryFactory;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;
import com.uds.pautando.features.change_meeting_agenda_status.data.repository.ChangeMeetingAgendaStatusRepositoryImpl;
import com.uds.pautando.features.change_meeting_agenda_status.domain.repository.ChangeMeetingAgendaStatusRepository;

public class ChangeMeetingAgendaStatusUseCase implements BaseUseCase<MutableLiveData<ChangeMeetingAgendaResponse>,ChangeMeetingAgendaStatusParams> {
    private ChangeMeetingAgendaStatusRepository repository;

    public ChangeMeetingAgendaStatusUseCase() {
        repository = RepositoryFactory.getChangeMeetingAgendaStatusRepository();
    }

    @Override
    public MutableLiveData<ChangeMeetingAgendaResponse> call(ChangeMeetingAgendaStatusParams changeMeetingAgendaStatusParams) {
        return repository.changeMeetingAgendaStatus(changeMeetingAgendaStatusParams.getMeetingAgenda());
    }
}

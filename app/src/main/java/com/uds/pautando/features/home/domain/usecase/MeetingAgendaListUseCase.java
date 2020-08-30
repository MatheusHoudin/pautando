package com.uds.pautando.features.home.domain.usecase;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.core.usecase.BaseUseCase;
import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;
import com.uds.pautando.features.home.data.repository.MeetingAgendaListRepositoryImpl;
import com.uds.pautando.features.home.domain.repository.MeetingAgendaListRepository;

public class MeetingAgendaListUseCase implements BaseUseCase<MutableLiveData<MeetingAgendaListResponse>, MeetingAgendaListParams> {
    private MeetingAgendaListRepository repository = new MeetingAgendaListRepositoryImpl();

    @Override
    public MutableLiveData<MeetingAgendaListResponse> call(MeetingAgendaListParams meetingAgendaListParams) {
        return repository.getMeetingAgendaList(meetingAgendaListParams.getOpenedMeetingAgendaList());
    }
}

package com.uds.pautando.features.home.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;
import com.uds.pautando.features.home.domain.usecase.MeetingAgendaListParams;
import com.uds.pautando.features.home.domain.usecase.MeetingAgendaListUseCase;

public class MeetingAgendaListViewModel extends ViewModel {
    private MeetingAgendaListUseCase useCase = new MeetingAgendaListUseCase();

    public MutableLiveData<MeetingAgendaListResponse> getMeetingAgendaList(Boolean isClosedMeetingAgendaList) {
        return useCase.call(new MeetingAgendaListParams(isClosedMeetingAgendaList));
    }
}

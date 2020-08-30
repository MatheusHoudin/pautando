package com.uds.pautando.features.home.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;

public interface MeetingAgendaListRepository {
    MutableLiveData<MeetingAgendaListResponse> getMeetingAgendaList(Boolean isOpenedMeetingAgendaList);
}

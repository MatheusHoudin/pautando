package com.uds.pautando.features.home.data.datasource;

import androidx.lifecycle.MutableLiveData;
import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;

public interface MeetingAgendaListRemoteDataSource {
    MutableLiveData<MeetingAgendaListResponse> getMeetingAgendaList(Boolean isOpenedMeetingAgendaList, String userUid);
}

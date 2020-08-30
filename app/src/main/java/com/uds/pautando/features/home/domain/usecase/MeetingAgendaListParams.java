package com.uds.pautando.features.home.domain.usecase;

public class MeetingAgendaListParams {
    private Boolean isOpenedMeetingAgendaList;

    public MeetingAgendaListParams(Boolean isOpenedMeetingAgendaList) {
        this.isOpenedMeetingAgendaList = isOpenedMeetingAgendaList;
    }

    public Boolean getOpenedMeetingAgendaList() {
        return isOpenedMeetingAgendaList;
    }
}

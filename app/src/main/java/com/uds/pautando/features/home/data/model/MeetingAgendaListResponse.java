package com.uds.pautando.features.home.data.model;

import com.uds.pautando.core.models.MeetingAgenda;

import java.util.List;

public class MeetingAgendaListResponse {
    private List<MeetingAgenda> meetingAgendaList;
    private Boolean isUnexpectedError;
    private Boolean thereAreNoMeetingAgenda;
    private String errorMessage;


    public MeetingAgendaListResponse(List<MeetingAgenda> meetingAgendaList, Boolean isUnexpectedError, Boolean thereAreNoMeetingAgenda, String errorMessage) {
        this.meetingAgendaList = meetingAgendaList;
        this.isUnexpectedError = isUnexpectedError;
        this.errorMessage = errorMessage;
        this.thereAreNoMeetingAgenda = thereAreNoMeetingAgenda;
    }

    public List<MeetingAgenda> getMeetingAgendaList() {
        return meetingAgendaList;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getThereAreNoMeetingAgenda() {
        return thereAreNoMeetingAgenda;
    }
}

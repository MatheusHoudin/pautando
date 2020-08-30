package com.uds.pautando.features.change_meeting_agenda_status.data.model;

public class ChangeMeetingAgendaResponse {
    private Boolean changeMeetingAgendaSuccessfully;
    private Boolean isUnexpectedError;
    private String errorMessage;

    public ChangeMeetingAgendaResponse(Boolean changeMeetingAgendaSuccessfully, Boolean isUnexpectedError, String errorMessage) {
        this.changeMeetingAgendaSuccessfully = changeMeetingAgendaSuccessfully;
        this.isUnexpectedError = isUnexpectedError;
        this.errorMessage = errorMessage;
    }

    public Boolean getChangeMeetingAgendaSuccessfully() {
        return changeMeetingAgendaSuccessfully;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

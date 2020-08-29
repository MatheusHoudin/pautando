package com.uds.pautando.features.create_meeting_agenda.domain.usecase;

public class CreateMeetingAgendaParams {
    private String title;
    private String description;
    private String details;

    public CreateMeetingAgendaParams(String title, String description, String details) {
        this.title = title;
        this.description = description;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

}

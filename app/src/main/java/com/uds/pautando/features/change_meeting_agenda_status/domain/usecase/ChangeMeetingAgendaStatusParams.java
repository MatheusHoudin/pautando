package com.uds.pautando.features.change_meeting_agenda_status.domain.usecase;

import com.uds.pautando.core.models.MeetingAgenda;

public class ChangeMeetingAgendaStatusParams {
    private MeetingAgenda meetingAgenda;

    public ChangeMeetingAgendaStatusParams(MeetingAgenda meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }

    public MeetingAgenda getMeetingAgenda() {
        return meetingAgenda;
    }
}

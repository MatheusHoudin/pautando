package com.uds.pautando.features.home.presentation.adapter;

import com.uds.pautando.core.models.MeetingAgenda;

public class MeetingAgendaItem {
    private MeetingAgenda meetingAgenda;
    private boolean isExpanded;

    public MeetingAgendaItem(MeetingAgenda meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
        this.isExpanded = false;
    }

    public MeetingAgenda getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(MeetingAgenda meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}

package com.uds.pautando.core.models;

import java.util.List;

public class User {
    private String uid;
    private String name;
    private String email;
    private List<MeetingAgenda> meetingAgendas;

    public User(String uid, String name, String email, List<MeetingAgenda> meetingAgendas) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.meetingAgendas = meetingAgendas;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<MeetingAgenda> getMeetingAgendas() {
        return meetingAgendas;
    }
}

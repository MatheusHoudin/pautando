package com.uds.pautando.core.models;

public class MeetingAgenda{
    private String title;
    private String description;
    private String details;
    private String author;
    private Boolean status;

    public MeetingAgenda(String title, String description, String details, String author) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.author = author;
    }

    public MeetingAgenda(String title, String description, String details, String author, Boolean status) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.author = author;
        this.status = status;
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

    public String getAuthor() {
        return author;
    }

    public Boolean getStatus() {
        return status;
    }
}

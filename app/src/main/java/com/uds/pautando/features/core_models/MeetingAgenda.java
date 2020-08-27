package com.uds.pautando.features.core_models;

public class MeetingAgenda {
    private String title;
    private String description;
    private String details;
    private String author;

    public MeetingAgenda(String title, String description, String details, String author) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.author = author;
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
}

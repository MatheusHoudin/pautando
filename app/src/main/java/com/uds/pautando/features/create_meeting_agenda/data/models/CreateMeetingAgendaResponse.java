package com.uds.pautando.features.create_meeting_agenda.data.models;

public class CreateMeetingAgendaResponse {
    private Boolean createdMeetingAgendaSuccessfully;
    private Boolean isDescriptionAndAuthorEmpty;
    private Boolean isDescriptionAndDetailsAndAuthorEmpty;
    private Boolean isDescriptionAndDetailsEmpty;
    private Boolean isDetailsAndAuthorEmpty;
    private Boolean isTitleAndAuthorEmpty;
    private Boolean isTitleAndDescriptionAndAuthorEmpty;
    private Boolean isTitleAndDescriptionAndDetailsAndAuthorEmpty;
    private Boolean isTitleAndDescriptionAndDetailsEmpty;
    private Boolean isTitleAndDescriptionEmpty;
    private Boolean isTitleAndDetailsEmpty;
    private Boolean isTitleEmpty;
    private Boolean thereIsAlreadyAMeetingAgendaWithSameName;
    private Boolean isDescriptionEmpty;
    private Boolean isDetailsEmpty;
    private Boolean isAuthorEmpty;
    private Boolean isUnexpectedError;
    private String titleErrorMessage;
    private String descriptionErrorMessage;
    private String detailsErrorMessage;
    private String authorErrorMessage;
    private String unexpectedErrorMessage;

    public CreateMeetingAgendaResponse(Boolean createdMeetingAgendaSuccessfully, Boolean isDescriptionAndAuthorEmpty, Boolean isDescriptionAndDetailsAndAuthorEmpty, Boolean isDescriptionAndDetailsEmpty, Boolean isDetailsAndAuthorEmpty, Boolean isTitleAndAuthorEmpty, Boolean isTitleAndDescriptionAndAuthorEmpty, Boolean isTitleAndDescriptionAndDetailsAndAuthorEmpty, Boolean isTitleAndDescriptionAndDetailsEmpty, Boolean isTitleAndDescriptionEmpty, Boolean isTitleAndDetailsEmpty, Boolean isTitleEmpty, Boolean isDescriptionEmpty, Boolean isDetailsEmpty, Boolean isAuthorEmpty, Boolean isUnexpectedError, String titleErrorMessage, String descriptionErrorMessage, String detailsErrorMessage, String authorErrorMessage, String unexpectedErrorMessage) {
        this.createdMeetingAgendaSuccessfully = createdMeetingAgendaSuccessfully;
        this.isDescriptionAndAuthorEmpty = isDescriptionAndAuthorEmpty;
        this.isDescriptionAndDetailsAndAuthorEmpty = isDescriptionAndDetailsAndAuthorEmpty;
        this.isDescriptionAndDetailsEmpty = isDescriptionAndDetailsEmpty;
        this.isDetailsAndAuthorEmpty = isDetailsAndAuthorEmpty;
        this.isTitleAndAuthorEmpty = isTitleAndAuthorEmpty;
        this.isTitleAndDescriptionAndAuthorEmpty = isTitleAndDescriptionAndAuthorEmpty;
        this.isTitleAndDescriptionAndDetailsAndAuthorEmpty = isTitleAndDescriptionAndDetailsAndAuthorEmpty;
        this.isTitleAndDescriptionAndDetailsEmpty = isTitleAndDescriptionAndDetailsEmpty;
        this.isTitleAndDescriptionEmpty = isTitleAndDescriptionEmpty;
        this.isTitleAndDetailsEmpty = isTitleAndDetailsEmpty;
        this.isTitleEmpty = isTitleEmpty;
        this.isDescriptionEmpty = isDescriptionEmpty;
        this.isDetailsEmpty = isDetailsEmpty;
        this.isAuthorEmpty = isAuthorEmpty;
        this.isUnexpectedError = isUnexpectedError;
        this.titleErrorMessage = titleErrorMessage;
        this.descriptionErrorMessage = descriptionErrorMessage;
        this.detailsErrorMessage = detailsErrorMessage;
        this.authorErrorMessage = authorErrorMessage;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
    }

    public CreateMeetingAgendaResponse(Boolean createdMeetingAgendaSuccessfully, Boolean isDescriptionAndAuthorEmpty, Boolean isDescriptionAndDetailsAndAuthorEmpty, Boolean isDescriptionAndDetailsEmpty, Boolean isDetailsAndAuthorEmpty, Boolean isTitleAndAuthorEmpty, Boolean isTitleAndDescriptionAndAuthorEmpty, Boolean isTitleAndDescriptionAndDetailsAndAuthorEmpty, Boolean isTitleAndDescriptionAndDetailsEmpty, Boolean isTitleAndDescriptionEmpty, Boolean isTitleAndDetailsEmpty, Boolean isTitleEmpty, Boolean thereIsAlreadyAMeetingAgendaWithSameName, Boolean isDescriptionEmpty, Boolean isDetailsEmpty, Boolean isAuthorEmpty, Boolean isUnexpectedError, String titleErrorMessage, String descriptionErrorMessage, String detailsErrorMessage, String authorErrorMessage, String unexpectedErrorMessage) {
        this.createdMeetingAgendaSuccessfully = createdMeetingAgendaSuccessfully;
        this.isDescriptionAndAuthorEmpty = isDescriptionAndAuthorEmpty;
        this.isDescriptionAndDetailsAndAuthorEmpty = isDescriptionAndDetailsAndAuthorEmpty;
        this.isDescriptionAndDetailsEmpty = isDescriptionAndDetailsEmpty;
        this.isDetailsAndAuthorEmpty = isDetailsAndAuthorEmpty;
        this.isTitleAndAuthorEmpty = isTitleAndAuthorEmpty;
        this.isTitleAndDescriptionAndAuthorEmpty = isTitleAndDescriptionAndAuthorEmpty;
        this.isTitleAndDescriptionAndDetailsAndAuthorEmpty = isTitleAndDescriptionAndDetailsAndAuthorEmpty;
        this.isTitleAndDescriptionAndDetailsEmpty = isTitleAndDescriptionAndDetailsEmpty;
        this.isTitleAndDescriptionEmpty = isTitleAndDescriptionEmpty;
        this.isTitleAndDetailsEmpty = isTitleAndDetailsEmpty;
        this.isTitleEmpty = isTitleEmpty;
        this.thereIsAlreadyAMeetingAgendaWithSameName = thereIsAlreadyAMeetingAgendaWithSameName;
        this.isDescriptionEmpty = isDescriptionEmpty;
        this.isDetailsEmpty = isDetailsEmpty;
        this.isAuthorEmpty = isAuthorEmpty;
        this.isUnexpectedError = isUnexpectedError;
        this.titleErrorMessage = titleErrorMessage;
        this.descriptionErrorMessage = descriptionErrorMessage;
        this.detailsErrorMessage = detailsErrorMessage;
        this.authorErrorMessage = authorErrorMessage;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
    }

    public CreateMeetingAgendaResponse(Boolean createdMeetingAgendaSuccessfully, Boolean isUnexpectedError, String unexpectedErrorMessage) {
        this.createdMeetingAgendaSuccessfully = createdMeetingAgendaSuccessfully;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
        this.isUnexpectedError = isUnexpectedError;
    }

    public Boolean getCreatedMeetingAgendaSuccessfully() {
        return createdMeetingAgendaSuccessfully;
    }

    public Boolean getDescriptionAndAuthorEmpty() {
        return isDescriptionAndAuthorEmpty;
    }

    public Boolean getDescriptionAndDetailsAndAuthorEmpty() {
        return isDescriptionAndDetailsAndAuthorEmpty;
    }

    public Boolean getDescriptionAndDetailsEmpty() {
        return isDescriptionAndDetailsEmpty;
    }

    public Boolean getDetailsAndAuthorEmpty() {
        return isDetailsAndAuthorEmpty;
    }

    public Boolean getTitleAndAuthorEmpty() {
        return isTitleAndAuthorEmpty;
    }

    public Boolean getTitleAndDescriptionAndAuthorEmpty() {
        return isTitleAndDescriptionAndAuthorEmpty;
    }

    public Boolean getTitleAndDescriptionAndDetailsAndAuthorEmpty() {
        return isTitleAndDescriptionAndDetailsAndAuthorEmpty;
    }

    public Boolean getTitleAndDescriptionAndDetailsEmpty() {
        return isTitleAndDescriptionAndDetailsEmpty;
    }

    public Boolean getTitleAndDescriptionEmpty() {
        return isTitleAndDescriptionEmpty;
    }

    public Boolean getTitleAndDetailsEmpty() {
        return isTitleAndDetailsEmpty;
    }

    public Boolean getTitleEmpty() {
        return isTitleEmpty;
    }

    public Boolean getDescriptionEmpty() {
        return isDescriptionEmpty;
    }

    public Boolean getDetailsEmpty() {
        return isDetailsEmpty;
    }

    public Boolean getAuthorEmpty() {
        return isAuthorEmpty;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getTitleErrorMessage() {
        return titleErrorMessage;
    }

    public String getDescriptionErrorMessage() {
        return descriptionErrorMessage;
    }

    public String getDetailsErrorMessage() {
        return detailsErrorMessage;
    }

    public String getAuthorErrorMessage() {
        return authorErrorMessage;
    }

    public String getUnexpectedErrorMessage() {
        return unexpectedErrorMessage;
    }
}

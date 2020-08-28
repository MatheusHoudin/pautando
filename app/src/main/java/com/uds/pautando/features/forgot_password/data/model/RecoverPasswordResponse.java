package com.uds.pautando.features.forgot_password.data.model;

public class RecoverPasswordResponse {
    private Boolean emailWasSentSuccessfully;
    private Boolean isEmptyEmail;
    private Boolean isInvalidEmail;
    private Boolean isUnexpectedError;
    private Boolean emailDoesNotExist;
    private String emailErrorMessage;
    private String unexpectedErrorMessage;

    public RecoverPasswordResponse(Boolean emailWasSentSuccessfully, Boolean isEmptyEmail, Boolean isInvalidEmail, Boolean isUnexpectedError,Boolean emailDoesNotExist, String emailErrorMessage, String unexpectedErrorMessage) {
        this.emailWasSentSuccessfully = emailWasSentSuccessfully;
        this.isEmptyEmail = isEmptyEmail;
        this.isInvalidEmail = isInvalidEmail;
        this.isUnexpectedError = isUnexpectedError;
        this.emailDoesNotExist = emailDoesNotExist;
        this.emailErrorMessage = emailErrorMessage;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
    }

    public Boolean getEmailWasSentSuccessfully() {
        return emailWasSentSuccessfully;
    }

    public Boolean getEmptyEmail() {
        return isEmptyEmail;
    }

    public Boolean getInvalidEmail() {
        return isInvalidEmail;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getUnexpectedErrorMessage() {
        return unexpectedErrorMessage;
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage;
    }
}

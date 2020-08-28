package com.uds.pautando.features.sign_in.data.model;

public class SignInResponse {
    private Boolean isUserLoggedInSuccessfully;
    private Boolean isEmailAndPasswordNotProvided;
    private Boolean isEmptyEmail;
    private Boolean isEmptyPassword;
    private Boolean isInvalidEmail;
    private Boolean isInvalidPassword;
    private Boolean isUnexpectedError;
    private String emailErrorMessage;
    private String passwordErrorMessage;
    private String unexpectedErrorMessage;


    public SignInResponse(Boolean userLoggedInSuccessfully, String emailErrorMessage) {
        this.isUserLoggedInSuccessfully = userLoggedInSuccessfully;
        this.emailErrorMessage = emailErrorMessage;
    }

    public SignInResponse(String emailErrorMessage, String passwordErrorMessage, Boolean isEmailAndPasswordNotProvided,
                          Boolean isEmptyEmail, Boolean isInvalidEmail, Boolean isInvalidPassword,
                          Boolean isUnexpectedError, Boolean isEmptyPassword) {
        this.emailErrorMessage = emailErrorMessage;
        this.passwordErrorMessage = passwordErrorMessage;
        this.isEmailAndPasswordNotProvided = isEmailAndPasswordNotProvided;
        this.isEmptyEmail = isEmptyEmail;
        this.isInvalidEmail = isInvalidEmail;
        this.isInvalidPassword = isInvalidPassword;
        this.isUnexpectedError = isUnexpectedError;
        this.isEmptyPassword = isEmptyPassword;
    }

    public SignInResponse(String emailErrorMessage, String passwordErrorMessage,
                          String unexpectedErrorMessage, Boolean isEmailAndPasswordNotProvided,
                          Boolean isEmptyEmail, Boolean isInvalidEmail, Boolean isInvalidPassword,
                          Boolean isUnexpectedError, Boolean isEmptyPassword) {
        this.emailErrorMessage = emailErrorMessage;
        this.passwordErrorMessage = passwordErrorMessage;
        this.isEmailAndPasswordNotProvided = isEmailAndPasswordNotProvided;
        this.isEmptyEmail = isEmptyEmail;
        this.isInvalidEmail = isInvalidEmail;
        this.isInvalidPassword = isInvalidPassword;
        this.isUnexpectedError = isUnexpectedError;
        this.isEmptyPassword = isEmptyPassword;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
    }

    public Boolean getUserLoggedInSuccessfully() {
        return isUserLoggedInSuccessfully;
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public Boolean getEmailAndPasswordNotProvided() {
        return isEmailAndPasswordNotProvided;
    }

    public Boolean getEmptyEmail() {
        return isEmptyEmail;
    }

    public Boolean getEmptyPassword() {
        return isEmptyPassword;
    }

    public Boolean getInvalidEmail() {
        return isInvalidEmail;
    }

    public Boolean getShortPassword() {
        return isInvalidPassword;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getUnexpectedErrorMessage() {
        return unexpectedErrorMessage;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isUserLoggedInSuccessfully=" + isUserLoggedInSuccessfully +
                ", isEmailAndPasswordNotProvided=" + isEmailAndPasswordNotProvided +
                ", isEmptyEmail=" + isEmptyEmail +
                ", isEmptyPassword=" + isEmptyPassword +
                ", isInvalidEmail=" + isInvalidEmail +
                ", isShortPassword=" + isInvalidPassword +
                ", isUnexpectedError=" + isUnexpectedError +
                ", emailErrorMessage='" + emailErrorMessage + '\'' +
                ", passwordErrorMessage='" + passwordErrorMessage + '\'' +
                '}';
    }
}

package com.uds.pautando.features.sign_up.data.model;

public class SignUpResponse {
    private Boolean signUpSuccessfully;
    private Boolean isEmailAndPasswordAndNameNotProvided;
    private Boolean isEmailAndPasswordNotProvided;
    private Boolean isEmailAndNameNotProvided;
    private Boolean isPasswordAndNameNotProvided;
    private Boolean emailWasAlreadyTaken;
    private Boolean isEmptyEmail;
    private Boolean isEmptyPassword;
    private Boolean isEmptyName;
    private Boolean isInvalidEmail;
    private Boolean isInvalidPassword;
    private Boolean isUnexpectedError;
    private String emailErrorMessage;
    private String passwordErrorMessage;
    private String nameErrorMessage;
    private String unexpectedErrorMessage;

    public SignUpResponse(Boolean signUpSuccessfully, String unexpectedErrorMessage) {
        this.signUpSuccessfully = signUpSuccessfully;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
    }

    public SignUpResponse(Boolean signUpSuccessfully, Boolean isEmailAndPasswordAndNameNotProvided, Boolean isEmailAndPasswordNotProvided, Boolean isEmailAndNameNotProvided, Boolean isPasswordAndNameNotProvided, Boolean isEmptyEmail, Boolean isEmptyPassword, Boolean isEmptyName, Boolean isInvalidEmail, Boolean isInvalidPassword, Boolean isUnexpectedError, Boolean emailWasAlreadyTaken, String emailErrorMessage, String passwordErrorMessage, String nameErrorMessage, String unexpectedErrorMessage) {
        this.signUpSuccessfully = signUpSuccessfully;
        this.isEmailAndPasswordAndNameNotProvided = isEmailAndPasswordAndNameNotProvided;
        this.isEmailAndPasswordNotProvided = isEmailAndPasswordNotProvided;
        this.isEmailAndNameNotProvided = isEmailAndNameNotProvided;
        this.isPasswordAndNameNotProvided = isPasswordAndNameNotProvided;
        this.isEmptyEmail = isEmptyEmail;
        this.isEmptyPassword = isEmptyPassword;
        this.isEmptyName = isEmptyName;
        this.isInvalidEmail = isInvalidEmail;
        this.isInvalidPassword = isInvalidPassword;
        this.isUnexpectedError = isUnexpectedError;
        this.emailErrorMessage = emailErrorMessage;
        this.passwordErrorMessage = passwordErrorMessage;
        this.unexpectedErrorMessage = unexpectedErrorMessage;
        this.emailWasAlreadyTaken = emailWasAlreadyTaken;
        this.nameErrorMessage = nameErrorMessage;
    }

    public Boolean getSignUpSuccessfully() {
        return signUpSuccessfully;
    }

    public Boolean getEmailAndPasswordAndNameNotProvided() {
        return isEmailAndPasswordAndNameNotProvided;
    }

    public Boolean getEmailAndPasswordNotProvided() {
        return isEmailAndPasswordNotProvided;
    }

    public Boolean getEmailAndNameNotProvided() {
        return isEmailAndNameNotProvided;
    }

    public Boolean getPasswordAndNameNotProvided() {
        return isPasswordAndNameNotProvided;
    }

    public Boolean getEmptyEmail() {
        return isEmptyEmail;
    }

    public Boolean getEmptyPassword() {
        return isEmptyPassword;
    }

    public Boolean getEmptyName() {
        return isEmptyName;
    }

    public Boolean getInvalidEmail() {
        return isInvalidEmail;
    }

    public Boolean getInvalidPassword() {
        return isInvalidPassword;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public String getUnexpectedErrorMessage() {
        return unexpectedErrorMessage;
    }
}

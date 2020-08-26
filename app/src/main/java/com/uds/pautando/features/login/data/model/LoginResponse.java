package com.uds.pautando.features.login.data.model;

public class LoginResponse {
    private Boolean isUserLoggedInSuccessfully;
    private Boolean isEmailAndPasswordNotProvided;
    private Boolean isEmptyEmail;
    private Boolean isEmptyPassword;
    private Boolean isInvalidEmail;
    private Boolean isShortPassword;
    private Boolean isUnexpectedError;
    private String errorMessage;

    public LoginResponse(Boolean userLoggedInSuccessfully, String errorMessage) {
        this.isUserLoggedInSuccessfully = userLoggedInSuccessfully;
        this.errorMessage = errorMessage;
    }

    public LoginResponse(String errorMessage, Boolean isEmailAndPasswordNotProvided,
                         Boolean isEmptyEmail,Boolean isInvalidEmail,Boolean isShortPassword,
                         Boolean isUnexpectedError, Boolean isEmptyPassword) {
        this.errorMessage = errorMessage;
        this.isEmailAndPasswordNotProvided = isEmailAndPasswordNotProvided;
        this.isEmptyEmail = isEmptyEmail;
        this.isInvalidEmail = isInvalidEmail;
        this.isShortPassword = isShortPassword;
        this.isUnexpectedError = isUnexpectedError;
        this.isEmptyPassword = isEmptyPassword;
    }

    public Boolean getUserLoggedInSuccessfully() {
        return isUserLoggedInSuccessfully;
    }

    public String getErrorMessage() {
        return errorMessage;
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
        return isShortPassword;
    }

    public Boolean getUnexpectedError() {
        return isUnexpectedError;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isUserLoggedInSuccessfully=" + isUserLoggedInSuccessfully +
                ", isEmailAndPasswordNotProvided=" + isEmailAndPasswordNotProvided +
                ", isEmptyEmail=" + isEmptyEmail +
                ", isEmptyPassword=" + isEmptyPassword +
                ", isInvalidEmail=" + isInvalidEmail +
                ", isShortPassword=" + isShortPassword +
                ", isUnexpectedError=" + isUnexpectedError +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

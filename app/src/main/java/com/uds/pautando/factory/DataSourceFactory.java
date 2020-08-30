package com.uds.pautando.factory;

import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSource;
import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSourceImpl;
import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSource;
import com.uds.pautando.features.create_meeting_agenda.data.datasource.CreateMeetingDataSourceImpl;
import com.uds.pautando.features.forgot_password.data.datasource.RecoverPasswordRemoteDataSource;
import com.uds.pautando.features.forgot_password.data.datasource.RecoverPasswordRemoteDataSourceImpl;
import com.uds.pautando.features.home.data.datasource.MeetingAgendaListRemoteDataSource;
import com.uds.pautando.features.home.data.datasource.MeetingAgendaListRemoteDataSourceImpl;
import com.uds.pautando.features.log_out.data.datasource.local.LogOutLocalDataSource;
import com.uds.pautando.features.log_out.data.datasource.local.LogOutLocalDataSourceImpl;
import com.uds.pautando.features.log_out.data.datasource.remote.LogOutRemoteDataSource;
import com.uds.pautando.features.log_out.data.datasource.remote.LogOutRemoteDataSourceImpl;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;
import com.uds.pautando.features.sign_in.data.datasource.remote.SignInRemoteDataSource;
import com.uds.pautando.features.sign_in.data.datasource.remote.SignInRemoteDataSourceImpl;
import com.uds.pautando.features.sign_up.data.datasource.SignUpRemoteDataSource;
import com.uds.pautando.features.sign_up.data.datasource.SignUpRemoteDataSourceImpl;

public class DataSourceFactory {
    private static SignUpRemoteDataSource signUpRemoteDataSource;
    private static SignInRemoteDataSource signInRemoteDataSource;
    private static SignInLocalDataSource signInLocalDataSource;
    private static LogOutLocalDataSource logOutLocalDataSource;
    private static LogOutRemoteDataSource logOutRemoteDataSource;
    private static MeetingAgendaListRemoteDataSource meetingAgendaListRemoteDataSource;
    private static RecoverPasswordRemoteDataSource recoverPasswordRemoteDataSource;
    private static CreateMeetingDataSource createMeetingDataSource;
    private static ChangeMeetingAgendaStatusRemoteDataSource changeMeetingAgendaStatusRemoteDataSource;

    public static SignUpRemoteDataSource getSignUpRemoteDataSource() {
        if(signUpRemoteDataSource == null) {
            signUpRemoteDataSource = new SignUpRemoteDataSourceImpl();
        }
        return signUpRemoteDataSource;
    }

    public static SignInRemoteDataSource getSignInRemoteDataSource() {
        if(signInRemoteDataSource == null) {
            signInRemoteDataSource = new SignInRemoteDataSourceImpl();
        }
        return signInRemoteDataSource;
    }

    public static SignInLocalDataSource getSignInLocalDataSource() {
        if(signInLocalDataSource == null) {
            signInLocalDataSource = new SignInLocalDataSourceImpl();
        }
        return signInLocalDataSource;
    }

    public static LogOutLocalDataSource getLogOutLocalDataSource() {
        if(logOutLocalDataSource == null) {
            logOutLocalDataSource = new LogOutLocalDataSourceImpl();
        }
        return logOutLocalDataSource;
    }

    public static LogOutRemoteDataSource getLogOutRemoteDataSource() {
        if(logOutRemoteDataSource == null) {
            logOutRemoteDataSource = new LogOutRemoteDataSourceImpl();
        }
        return logOutRemoteDataSource;
    }

    public static MeetingAgendaListRemoteDataSource getMeetingAgendaListRemoteDataSource() {
        if(meetingAgendaListRemoteDataSource == null) {
            meetingAgendaListRemoteDataSource = new MeetingAgendaListRemoteDataSourceImpl();
        }
        return meetingAgendaListRemoteDataSource;
    }

    public static RecoverPasswordRemoteDataSource getRecoverPasswordRemoteDataSource() {
        if(recoverPasswordRemoteDataSource == null) {
            recoverPasswordRemoteDataSource = new RecoverPasswordRemoteDataSourceImpl();
        }
        return recoverPasswordRemoteDataSource;
    }

    public static CreateMeetingDataSource getCreateMeetingDataSource() {
        if(createMeetingDataSource == null) {
            createMeetingDataSource = new CreateMeetingDataSourceImpl();
        }
        return createMeetingDataSource;
    }

    public static ChangeMeetingAgendaStatusRemoteDataSource getChangeMeetingAgendaStatusRemoteDataSource() {
        if(changeMeetingAgendaStatusRemoteDataSource == null) {
            changeMeetingAgendaStatusRemoteDataSource = new ChangeMeetingAgendaStatusRemoteDataSourceImpl();
        }
        return changeMeetingAgendaStatusRemoteDataSource;
    }

}

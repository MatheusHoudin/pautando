package com.uds.pautando.factory;

import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSource;
import com.uds.pautando.features.change_meeting_agenda_status.data.datasource.ChangeMeetingAgendaStatusRemoteDataSourceImpl;
import com.uds.pautando.features.change_meeting_agenda_status.data.repository.ChangeMeetingAgendaStatusRepositoryImpl;
import com.uds.pautando.features.change_meeting_agenda_status.domain.repository.ChangeMeetingAgendaStatusRepository;
import com.uds.pautando.features.create_meeting_agenda.data.repository.CreateMeetingAgendaRepositoryImpl;
import com.uds.pautando.features.create_meeting_agenda.domain.repository.CreateMeetingAgendaRepository;
import com.uds.pautando.features.forgot_password.data.repository.RecoverPasswordRepositoryImpl;
import com.uds.pautando.features.forgot_password.domain.repository.RecoverPasswordRepository;
import com.uds.pautando.features.home.data.repository.MeetingAgendaListRepositoryImpl;
import com.uds.pautando.features.home.domain.repository.MeetingAgendaListRepository;
import com.uds.pautando.features.log_out.data.repository.LogOutRepositoryImpl;
import com.uds.pautando.features.log_out.domain.repository.LogOutRepository;
import com.uds.pautando.features.sign_in.data.repository.SignInRepositoryImpl;
import com.uds.pautando.features.sign_in.domain.repository.SignInRepository;
import com.uds.pautando.features.sign_up.data.repository.SignUpRepositoryImpl;
import com.uds.pautando.features.sign_up.domain.repository.SignUpRepository;

public class RepositoryFactory {
    private static SignUpRepository signUpRepository;
    private static SignInRepository signInRepository;
    private static LogOutRepository logOutRepository;
    private static MeetingAgendaListRepository meetingAgendaListRepository;
    private static RecoverPasswordRepository recoverPasswordRepository;
    private static CreateMeetingAgendaRepository createMeetingAgendaRepository;
    private static ChangeMeetingAgendaStatusRepository changeMeetingAgendaStatusRepository;

    public static SignUpRepository getSignUpRepository() {
        if(signUpRepository == null) {
            signUpRepository = new SignUpRepositoryImpl();
        }
        return signUpRepository;
    }

    public static SignInRepository getSignInRepository() {
        if(signInRepository == null) {
            signInRepository = new SignInRepositoryImpl();
        }
        return signInRepository;
    }

    public static LogOutRepository getLogOutRepository() {
        if(logOutRepository == null) {
            logOutRepository = new LogOutRepositoryImpl();
        }
        return logOutRepository;
    }

    public static MeetingAgendaListRepository getMeetingAgendaListRepository() {
        if(meetingAgendaListRepository == null) {
            meetingAgendaListRepository = new MeetingAgendaListRepositoryImpl();
        }
        return meetingAgendaListRepository;
    }

    public static RecoverPasswordRepository getRecoverPasswordRepository() {
        if(recoverPasswordRepository == null) {
            recoverPasswordRepository = new RecoverPasswordRepositoryImpl();
        }
        return recoverPasswordRepository;
    }

    public static CreateMeetingAgendaRepository getCreateMeetingAgendaRepository() {
        if(createMeetingAgendaRepository == null) {
            createMeetingAgendaRepository = new CreateMeetingAgendaRepositoryImpl();
        }
        return createMeetingAgendaRepository;
    }

    public static ChangeMeetingAgendaStatusRepository getChangeMeetingAgendaStatusRepository() {
        if(changeMeetingAgendaStatusRepository == null) {
            changeMeetingAgendaStatusRepository = new ChangeMeetingAgendaStatusRepositoryImpl();
        }
        return changeMeetingAgendaStatusRepository;
    }
}

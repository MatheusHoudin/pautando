package com.uds.pautando.factory;

import com.uds.pautando.features.change_meeting_agenda_status.domain.usecase.ChangeMeetingAgendaStatusUseCase;
import com.uds.pautando.features.create_meeting_agenda.domain.usecase.CreateMeetingAgendaUseCase;
import com.uds.pautando.features.forgot_password.domain.usecase.RecoverPasswordUseCase;
import com.uds.pautando.features.home.domain.usecase.MeetingAgendaListUseCase;
import com.uds.pautando.features.log_out.domain.usecase.LogOutUseCase;
import com.uds.pautando.features.sign_in.domain.usecase.GetCurrentUserUseCase;
import com.uds.pautando.features.sign_in.domain.usecase.SignInUseCase;
import com.uds.pautando.features.sign_up.domain.usecase.SignUpUseCase;

public class UseCaseFactory {
    private static SignUpUseCase signUpUseCase;
    private static GetCurrentUserUseCase getCurrentUserUseCase;
    private static SignInUseCase signInUseCase;
    private static LogOutUseCase logOutUseCase;
    private static MeetingAgendaListUseCase meetingAgendaListUseCase;
    private static RecoverPasswordUseCase recoverPasswordUseCase;
    private static CreateMeetingAgendaUseCase createMeetingAgendaUseCase;
    private static ChangeMeetingAgendaStatusUseCase changeMeetingAgendaStatusUseCase;

    public static SignUpUseCase getSignUpUseCase() {
        if(signUpUseCase == null) {
            signUpUseCase = new SignUpUseCase();
        }
        return signUpUseCase;
    }

    public static GetCurrentUserUseCase getGetCurrentUserUseCase() {
        if (getCurrentUserUseCase == null) {
            getCurrentUserUseCase = new GetCurrentUserUseCase();
        }
        return getCurrentUserUseCase;
    }

    public static SignInUseCase getSignInUseCase() {
        if(signInUseCase == null) {
            signInUseCase = new SignInUseCase();
        }
        return signInUseCase;
    }

    public static LogOutUseCase getLogOutUseCase() {
        if(logOutUseCase == null) {
            logOutUseCase = new LogOutUseCase();
        }
        return logOutUseCase;
    }

    public static MeetingAgendaListUseCase getMeetingAgendaListUseCase() {
        if(meetingAgendaListUseCase == null) {
            meetingAgendaListUseCase = new MeetingAgendaListUseCase();
        }
        return meetingAgendaListUseCase;
    }

    public static RecoverPasswordUseCase getRecoverPasswordUseCase() {
        if(recoverPasswordUseCase == null) {
            recoverPasswordUseCase = new RecoverPasswordUseCase();
        }
        return recoverPasswordUseCase;
    }

    public static CreateMeetingAgendaUseCase getCreateMeetingAgendaUseCase() {
        if(createMeetingAgendaUseCase == null) {
            createMeetingAgendaUseCase = new CreateMeetingAgendaUseCase();
        }
        return createMeetingAgendaUseCase;
    }

    public static ChangeMeetingAgendaStatusUseCase getChangeMeetingAgendaStatusUseCase() {
        if(changeMeetingAgendaStatusUseCase == null) {
            changeMeetingAgendaStatusUseCase = new ChangeMeetingAgendaStatusUseCase();
        }
        return changeMeetingAgendaStatusUseCase;
    }
}

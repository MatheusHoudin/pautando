package com.uds.pautando.features.home.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.uds.pautando.factory.DataSourceFactory;
import com.uds.pautando.features.home.data.datasource.MeetingAgendaListRemoteDataSource;
import com.uds.pautando.features.home.data.datasource.MeetingAgendaListRemoteDataSourceImpl;
import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;
import com.uds.pautando.features.home.domain.repository.MeetingAgendaListRepository;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSource;
import com.uds.pautando.features.sign_in.data.datasource.local.SignInLocalDataSourceImpl;

public class MeetingAgendaListRepositoryImpl implements MeetingAgendaListRepository {
    private MeetingAgendaListRemoteDataSource remoteDataSource;
    private SignInLocalDataSource signInLocalDataSource;

    public MeetingAgendaListRepositoryImpl() {
        remoteDataSource = DataSourceFactory.getMeetingAgendaListRemoteDataSource();
        signInLocalDataSource = DataSourceFactory.getSignInLocalDataSource();
    }

    @Override
    public MutableLiveData<MeetingAgendaListResponse> getMeetingAgendaList(Boolean isOpenedMeetingAgendaList) {
        return remoteDataSource.getMeetingAgendaList(isOpenedMeetingAgendaList,signInLocalDataSource.getCurrentUser().getUid());
    }
}

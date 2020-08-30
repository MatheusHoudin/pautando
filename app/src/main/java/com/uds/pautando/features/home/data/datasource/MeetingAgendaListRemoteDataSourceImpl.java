package com.uds.pautando.features.home.data.datasource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.factory.FirebaseFactory;
import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class MeetingAgendaListRemoteDataSourceImpl implements MeetingAgendaListRemoteDataSource {
    private FirebaseFirestore firestore;

    public MeetingAgendaListRemoteDataSourceImpl(){
        firestore = FirebaseFactory.getFirebaseFirestore();
    }
    @Override
    public MutableLiveData<MeetingAgendaListResponse> getMeetingAgendaList(final Boolean isOpenedMeetingAgendaList, String userUid) {

        final MutableLiveData<MeetingAgendaListResponse> mutableLiveData = new MutableLiveData<>();
        firestore.collection("users").whereEqualTo("uid", userUid).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null) {
                    mutableLiveData.postValue(new MeetingAgendaListResponse(
                      null, true, false,
                      "Ocorreu um erro ao buscar as suas pautas, por favor tente novamente"
                    ));
                }else{
                    List<Map<String,Object>> meetingAgendaList = (List<Map<String, Object>>) queryDocumentSnapshots.getDocuments().get(0).get("meetingAgendas");
                    List<MeetingAgenda> filteredList = new ArrayList<>();

                    if(meetingAgendaList != null) {
                        for(Map<String,Object> m : meetingAgendaList) {
                            if(m.get("status") == isOpenedMeetingAgendaList) {
                                filteredList.add(new MeetingAgenda(
                                        m.get("title").toString(),
                                        m.get("description").toString(),
                                        m.get("details").toString(),
                                        m.get("author").toString(),
                                        (Boolean) m.get("status")
                                ));
                            }
                        }
                    }

                    Log.i("RESULT", filteredList.toString());

                    if(filteredList == null || filteredList.size() == 0) {
                        mutableLiveData.postValue(new MeetingAgendaListResponse(
                          null, false, true,
                          "Você não teu pautas cadastradas no momento, aceita criar uma?"
                        ));
                    }else{
                        mutableLiveData.postValue(new MeetingAgendaListResponse(
                          filteredList, false, false,
                          "As suas pautas foram encontradas com sucesso"
                        ));
                    }
                }
            }
        });
        return mutableLiveData;
    }
}
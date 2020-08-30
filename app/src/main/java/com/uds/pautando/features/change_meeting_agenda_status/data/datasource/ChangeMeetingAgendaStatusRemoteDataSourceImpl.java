package com.uds.pautando.features.change_meeting_agenda_status.data.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.factory.FirebaseFactory;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;

import java.util.ArrayList;
import java.util.Map;

public class ChangeMeetingAgendaStatusRemoteDataSourceImpl implements ChangeMeetingAgendaStatusRemoteDataSource {
    FirebaseFirestore firestore;

    public ChangeMeetingAgendaStatusRemoteDataSourceImpl(){
        firestore = FirebaseFactory.getFirebaseFirestore();
    }

    @Override
    public MutableLiveData<ChangeMeetingAgendaResponse> changeMeeringAgendaState(final MeetingAgenda meetingAgenda, String userUid) {
        final MutableLiveData<ChangeMeetingAgendaResponse> mutableLiveData = new MutableLiveData<>();

        firestore.collection("users").whereEqualTo("uid",userUid).limit(1).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            DocumentSnapshot snapshot = task.getResult().getDocuments().get(0);
                            ArrayList<Map<String,Object>> meetingAgendaList =
                                    (ArrayList<Map<String,Object>>)
                                            snapshot.get("meetingAgendas");

                            for(Map<String,Object> data : meetingAgendaList) {
                                if(data.get("title").toString().equals(meetingAgenda.getTitle())) {
                                    data.put("status", !((boolean)data.get("status")));
                                }
                            }

                            snapshot.getReference().update("meetingAgendas", meetingAgendaList)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                mutableLiveData.postValue(new ChangeMeetingAgendaResponse(
                                                  true, false, null
                                                ));
                                            }else{
                                                mutableLiveData.postValue(new ChangeMeetingAgendaResponse(
                                                  false, true, "Ocorreu um erro ao tentar alterar a pauta, por favor tente novamente"
                                                ));
                                            }
                                        }
                                    });
                        }else{
                            mutableLiveData.postValue(new ChangeMeetingAgendaResponse(
                              false, true, "Ocorreu um erro ao tentar alterar a pauta, por favor tente novamente"
                            ));
                        }
                    }
                });
        return mutableLiveData;
    }
}

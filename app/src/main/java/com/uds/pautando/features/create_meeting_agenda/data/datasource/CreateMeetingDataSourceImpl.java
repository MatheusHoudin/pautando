package com.uds.pautando.features.create_meeting_agenda.data.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.uds.pautando.factory.FirebaseFactory;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class CreateMeetingDataSourceImpl implements CreateMeetingDataSource {
    FirebaseFirestore firestore;

    public CreateMeetingDataSourceImpl(){
        firestore = FirebaseFactory.getFirebaseFirestore();
    }

    @Override
    public MutableLiveData<CreateMeetingAgendaResponse> createMeetingAgenda(final MeetingAgenda meetingAgenda, String userUid) {
        final MutableLiveData<CreateMeetingAgendaResponse> mutableLiveData = new MutableLiveData<>();
        firestore.collection("users").whereEqualTo("uid", userUid).limit(1)
        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult().getDocuments().get(0);
                    ArrayList<Map<String,Object>> meetingAgendaList =
                            (ArrayList<Map<String,Object>>)
                                    snapshot.get("meetingAgendas");
                    System.out.println(meetingAgendaList);
                    System.out.println(meetingAgendaList.size());

                    boolean thereIsAlreadyAMeetingAgendaWithSameName = false;
                    for(Map<String,Object> mapData : meetingAgendaList) {
                        Log.i("DATA", mapData.get("title").toString());
                        Log.i("DATA", meetingAgenda.getTitle().getValue());
                        if(mapData.get("title").toString().equals(meetingAgenda.getTitle().getValue())) {
                            thereIsAlreadyAMeetingAgendaWithSameName = true;
                            break;
                        }
                    }

                    if(thereIsAlreadyAMeetingAgendaWithSameName) {
                        mutableLiveData.postValue(new CreateMeetingAgendaResponse(
                          false, false, false, false, false, false, false,
                          false, false, false, false, false, true, false, false, false, false, "Já existe uma pauta com esse mesmo nome, tente criar outro nome, por favor", null,
                          null, null, null
                        ));
                    }else{
                        Map<String, Object> data = new HashMap<>();
                        data.put("title",meetingAgenda.getTitle().getValue());
                        data.put("description",meetingAgenda.getDescription().getValue());
                        data.put("details",meetingAgenda.getDetails().getValue());
                        data.put("author",meetingAgenda.getAuthor().getValue());
                        data.put("status",meetingAgenda.isStatus());
                        meetingAgendaList.add(data);

                        snapshot.getReference().update("meetingAgendas", meetingAgendaList)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {
                                            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
                                                    true, false, null
                                            ));
                                        }else{
                                            mutableLiveData.postValue(new CreateMeetingAgendaResponse(
                                                    false, true, "Ocorreu um erro ao criar a pauta, por favor tente novamente"
                                            ));
                                        }
                                    }
                                });

                    }

                }else{
                    mutableLiveData.postValue(new CreateMeetingAgendaResponse(
                            false, false, false, false, false, false, false,
                            false, false, false, false, false, false, false, false, true, null, null,
                            null, null, "Ocorreu um erro ao criar a pauta, por favor tente novamente"
                    ));
                }
            }
        });
        return mutableLiveData;
    }
}
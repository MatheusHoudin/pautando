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
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.data.models.MeetingAgenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class CreateMeetingDataSourceImpl implements CreateMeetingDataSource {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    public CreateMeetingDataSourceImpl(){
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
          .setTimestampsInSnapshotsEnabled(true)
          .build();
        firestore.setFirestoreSettings(settings);
    }

    @Override
    public MutableLiveData<CreateMeetingAgendaResponse> createMeetingAgenda(final MeetingAgenda meetingAgenda) {
        final MutableLiveData<CreateMeetingAgendaResponse> mutableLiveData = new MutableLiveData<>();
        String uid = firebaseAuth.getCurrentUser().getUid();
        firestore.collection("users").whereEqualTo("uid", uid)
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
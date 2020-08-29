package com.uds.pautando.features.home.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uds.pautando.R;
import com.uds.pautando.features.create_meeting_agenda.presentation.pages.CreateMeetingAgendaPage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeetingAgendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetingAgendaFragment extends Fragment {
    private RecyclerView meetingAgendaRecyclerView;

    public static MeetingAgendaFragment newInstance(String param1, String param2) {
        MeetingAgendaFragment fragment = new MeetingAgendaFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_agenda, container, false);
        CardView createMeetingAgenda = view.findViewById(R.id.create_meeting_agenda);

        createMeetingAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateMeetingAgendaPage.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
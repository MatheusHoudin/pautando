package com.uds.pautando.features.home.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uds.pautando.R;
import com.uds.pautando.core.models.MeetingAgenda;
import com.uds.pautando.features.create_meeting_agenda.presentation.pages.CreateMeetingAgendaPage;
import com.uds.pautando.features.home.data.model.MeetingAgendaListResponse;
import com.uds.pautando.features.home.presentation.adapter.MeetingAgendaAdapter;
import com.uds.pautando.features.home.presentation.adapter.MeetingAgendaItem;
import com.uds.pautando.features.home.presentation.viewmodel.MeetingAgendaListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeetingAgendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetingAgendaFragment extends Fragment {
    private static final String TYPE = "TYPE";
    private RecyclerView meetingAgendaRecyclerView;
    private List<MeetingAgendaItem> meetingAgendaItems = new ArrayList<>();
    private boolean isOpenedMeetingAgendaFragment;

    public static MeetingAgendaFragment newInstance(Boolean isClosedMeetingAgendaFragment) {
        MeetingAgendaFragment fragment = new MeetingAgendaFragment();
        Bundle args = new Bundle();
        args.putBoolean(TYPE, isClosedMeetingAgendaFragment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isOpenedMeetingAgendaFragment = getArguments().getBoolean(TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_agenda, container, false);
        CardView createMeetingAgenda = view.findViewById(R.id.create_meeting_agenda);
        CardView header = view.findViewById(R.id.header);
        TextView headerTitle = view.findViewById(R.id.header_title);
        final TextView thereAreNoMeetingAgendasText = view.findViewById(R.id.there_are_no_meeting_agendas_text);
        final LinearLayout thereAreNoMeetingAgendas = view.findViewById(R.id.there_are_no_meeting_agendas);
        final Button thereAreNoMeetingAgendasButton = view.findViewById(R.id.there_are_no_meeting_agendas_button);
        final RecyclerView recyclerView = view.findViewById(R.id.meeting_agenda_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        if(!isOpenedMeetingAgendaFragment) {
            headerTitle.setText(getResources().getString(R.string.closed_meeting_agendas));
            thereAreNoMeetingAgendasButton.setBackground(getResources().getDrawable(R.drawable.custom_create_agenda_red_rounded_button));

            header.setCardBackgroundColor(getResources().getColor(R.color.lightRed));
        }else{
            headerTitle.setText(getResources().getString(R.string.opened_meeting_agendas));
            thereAreNoMeetingAgendasButton.setBackground(getResources().getDrawable(R.drawable.custom_create_agenda_blue_rounded_button));
            header.setCardBackgroundColor(getResources().getColor(R.color.lightGreen));
        }

        new MeetingAgendaListViewModel().getMeetingAgendaList(isOpenedMeetingAgendaFragment)
        .observe(getActivity(), new Observer<MeetingAgendaListResponse>() {
            @Override
            public void onChanged(MeetingAgendaListResponse meetingAgendaListResponse) {
                if(meetingAgendaListResponse.getThereAreNoMeetingAgenda()) {
                    thereAreNoMeetingAgendas.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    thereAreNoMeetingAgendasText.setText("Você não possui pautas "+(isOpenedMeetingAgendaFragment ? "em aberto" : "fechadas")+" cadastradas no momento, vamos criar uma?");
                }else if(meetingAgendaListResponse.getUnexpectedError()) {
                    Toast.makeText(getContext(),meetingAgendaListResponse.getErrorMessage(),Toast.LENGTH_LONG).show();
                }else{
                    thereAreNoMeetingAgendas.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    List<MeetingAgendaItem> newMeetingAgendaItems = new ArrayList<>();
                    for(MeetingAgenda m : meetingAgendaListResponse.getMeetingAgendaList()) {
                        newMeetingAgendaItems.add(new MeetingAgendaItem(m));
                    }
                    final MeetingAgendaAdapter adapter = new MeetingAgendaAdapter(newMeetingAgendaItems, isOpenedMeetingAgendaFragment, getActivity());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        thereAreNoMeetingAgendasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateMeetingAgendaPage.class);
                startActivity(intent);
            }
        });
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
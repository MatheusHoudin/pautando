package com.uds.pautando.features.home.presentation.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.uds.pautando.R;
import com.uds.pautando.features.change_meeting_agenda_status.data.model.ChangeMeetingAgendaResponse;
import com.uds.pautando.features.change_meeting_agenda_status.presentation.viewmodel.ChangeMeetingAgendaStatusViewModel;
import com.uds.pautando.features.home.presentation.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class MeetingAgendaAdapter extends RecyclerView.Adapter<MeetingAgendaAdapter.MeetingAgendaViewHolder> {
    private List<MeetingAgendaItem> meetingAgendaItemList = new ArrayList<>();
    private Boolean isOpenedMeetingAgenda;
    private LifecycleOwner lifeCycleOwner;

    public MeetingAgendaAdapter(List<MeetingAgendaItem> meetingAgendaItemList, Boolean isOpenedMeetingAgenda, LifecycleOwner lifeCycleOwner) {
        this.meetingAgendaItemList = meetingAgendaItemList;
        this.isOpenedMeetingAgenda = isOpenedMeetingAgenda;
        this.lifeCycleOwner = lifeCycleOwner;
    }

    @NonNull
    @Override
    public MeetingAgendaAdapter.MeetingAgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_agenda_list_item, parent, false);
        return new MeetingAgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingAgendaAdapter.MeetingAgendaViewHolder holder, int position) {
        MeetingAgendaItem meetingAgenda = meetingAgendaItemList.get(position);
        holder.title.setText(meetingAgenda.getMeetingAgenda().getTitle());
        holder.shortDescription.setText(meetingAgenda.getMeetingAgenda().getDescription());
        holder.details.setText(meetingAgenda.getMeetingAgenda().getDetails());
        holder.author.setText(meetingAgenda.getMeetingAgenda().getAuthor());

        boolean isExpanded = meetingAgenda.isExpanded();
        holder.expandableSection.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return meetingAgendaItemList.size();
    }

    public class MeetingAgendaViewHolder extends RecyclerView.ViewHolder {
        private TextView title,shortDescription,details,author;
        private LinearLayout expandableSection;
        private CardView changeMeetingAgendaStatus;
        private View meetingAgendaDivider;

        public MeetingAgendaViewHolder(@NonNull final View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.meeting_agenda_item_title);
            shortDescription = itemView.findViewById(R.id.meeting_agenda_item_title_short_description);
            details = itemView.findViewById(R.id.meeting_agenda_item_details);
            author = itemView.findViewById(R.id.meeting_agenda_item_author);

            meetingAgendaDivider = itemView.findViewById(R.id.meeting_agenda_divider);
            meetingAgendaDivider.setBackgroundColor(itemView.getResources().getColor(
              !isOpenedMeetingAgenda ? R.color.lightRed : R.color.lightGreen
            ));
            changeMeetingAgendaStatus = itemView.findViewById(R.id.change_meeting_status_action);
            changeMeetingAgendaStatus.setCardBackgroundColor(itemView.getResources().getColor(
              isOpenedMeetingAgenda ? R.color.lightRed : R.color.lightGreen
            ));
            expandableSection = itemView.findViewById(R.id.expandable_section);

            changeMeetingAgendaStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final MeetingAgendaItem meetingAgendaItem = meetingAgendaItemList.get(getAdapterPosition());
                    new ChangeMeetingAgendaStatusViewModel().changeMeetingAgendaStatus(meetingAgendaItem.getMeetingAgenda())
                    .observe(lifeCycleOwner, new Observer<ChangeMeetingAgendaResponse>() {
                        @Override
                        public void onChanged(ChangeMeetingAgendaResponse changeMeetingAgendaResponse) {
                            if(changeMeetingAgendaResponse.getChangeMeetingAgendaSuccessfully()) {
                                Toast.makeText(itemView.getContext(), "A pauta "+meetingAgendaItem.getMeetingAgenda().getTitle()+" foi atualizada com sucesso", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(itemView.getContext(), changeMeetingAgendaResponse.getErrorMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MeetingAgendaItem meetingAgendaItem = meetingAgendaItemList.get(getAdapterPosition());
                    if(!meetingAgendaItem.isExpanded()) {
                        for(MeetingAgendaItem m : meetingAgendaItemList) {
                            if(m.isExpanded()) {
                                m.setExpanded(false);
                                break;
                            }
                        }
                    }
                    meetingAgendaItem.setExpanded(!meetingAgendaItem.isExpanded());
                    notifyDataSetChanged();
                }
            });
        }
    }
}

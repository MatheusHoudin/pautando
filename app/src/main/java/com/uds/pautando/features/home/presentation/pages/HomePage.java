package com.uds.pautando.features.home.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import com.uds.pautando.R;
import com.uds.pautando.features.home.presentation.fragment.MeetingAgendaFragment;
import com.uds.pautando.features.home.presentation.fragment.ProfileFragment;
import com.uds.pautando.features.log_out.domain.viewmodel.LogOutViewModel;
import com.uds.pautando.features.sign_in.presentation.pages.SignInPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final CardView openedMeetingAgendaAction = findViewById(R.id.opened_meeting_agenda_action);
        final CardView closedMeetingAgendaAction = findViewById(R.id.closed_meeting_agenda_action);
        final CardView profileAction = findViewById(R.id.profile_action);

        final CardView openedMeetingAgendaCircle = findViewById(R.id.opened_meeting_agenda_circle);
        final CardView closedMeetingAgendaCircle = findViewById(R.id.closed_meeting_agenda_circle);
        final CardView profileCircle = findViewById(R.id.profile_circle);
        final CardView logOut = findViewById(R.id.log_out);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_page_container, new MeetingAgendaFragment());
        ft.commit();

        openedMeetingAgendaAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          openedMeetingAgendaCircle.setVisibility(View.VISIBLE);
          closedMeetingAgendaCircle.setVisibility(View.GONE);
          profileCircle.setVisibility(View.GONE);
          FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
          ft.replace(R.id.main_page_container, new MeetingAgendaFragment());
          ft.commit();
            }
        });

        closedMeetingAgendaAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          openedMeetingAgendaCircle.setVisibility(View.GONE);
          closedMeetingAgendaCircle.setVisibility(View.VISIBLE);
          profileCircle.setVisibility(View.GONE);
          FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
          ft.replace(R.id.main_page_container, new MeetingAgendaFragment());
          ft.commit();
            }
        });

        profileAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          openedMeetingAgendaCircle.setVisibility(View.GONE);
          closedMeetingAgendaCircle.setVisibility(View.GONE);
          profileCircle.setVisibility(View.VISIBLE);
          FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
          ft.replace(R.id.main_page_container, new ProfileFragment());
          ft.commit();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LogOutViewModel().logOut();
                Intent intent = new Intent(getApplicationContext(), SignInPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
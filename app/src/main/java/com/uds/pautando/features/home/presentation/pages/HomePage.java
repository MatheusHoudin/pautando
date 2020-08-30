package com.uds.pautando.features.home.presentation.pages;

import androidx.annotation.NonNull;
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
import android.os.PersistableBundle;
import android.view.View;

public class HomePage extends AppCompatActivity {
    private MeetingAgendaFragment openedMeetingAgendaFragment;
    private MeetingAgendaFragment closedMeetingAgendaFragment;
    private ProfileFragment profileFragment;
    private CardView openedMeetingAgendaCircle;
    private CardView closedMeetingAgendaCircle;
    private CardView profileCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final CardView openedMeetingAgendaAction = findViewById(R.id.opened_meeting_agenda_action);
        final CardView closedMeetingAgendaAction = findViewById(R.id.closed_meeting_agenda_action);
        final CardView profileAction = findViewById(R.id.profile_action);

        openedMeetingAgendaCircle = findViewById(R.id.opened_meeting_agenda_circle);
        closedMeetingAgendaCircle = findViewById(R.id.closed_meeting_agenda_circle);
        profileCircle = findViewById(R.id.profile_circle);
        final CardView logOut = findViewById(R.id.log_out);

        openedMeetingAgendaFragment = MeetingAgendaFragment.newInstance(true);
        closedMeetingAgendaFragment = MeetingAgendaFragment.newInstance(false);
        profileFragment = new ProfileFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_page_container, openedMeetingAgendaFragment);
        ft.commit();

        openedMeetingAgendaAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          openedMeetingAgendaCircle.setVisibility(View.VISIBLE);
          closedMeetingAgendaCircle.setVisibility(View.GONE);
          profileCircle.setVisibility(View.GONE);
          FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
          ft.replace(R.id.main_page_container, openedMeetingAgendaFragment);
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
          ft.replace(R.id.main_page_container, closedMeetingAgendaFragment);
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
          ft.replace(R.id.main_page_container, profileFragment);
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

    @Override
    protected void onResume() {
        super.onResume();
        openedMeetingAgendaCircle.setVisibility(View.VISIBLE);
        closedMeetingAgendaCircle.setVisibility(View.GONE);
        profileCircle.setVisibility(View.GONE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_page_container, openedMeetingAgendaFragment);
        ft.commit();
    }
}
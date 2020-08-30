package com.uds.pautando.features.create_meeting_agenda.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.BaseKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uds.pautando.R;
import com.uds.pautando.features.create_meeting_agenda.data.models.CreateMeetingAgendaResponse;
import com.uds.pautando.features.create_meeting_agenda.presentation.viewmodel.CreateMeetingAgendaViewModel;

public class CreateMeetingAgendaPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting_agenda);

        ImageView backToHome = findViewById(R.id.back_to_home);
        final EditText title = findViewById(R.id.meeting_agenda_title_field);
        final EditText description = findViewById(R.id.meeting_agenda_description_field);
        final EditText details = findViewById(R.id.meeting_agenda_details_field);
        final EditText author = findViewById(R.id.meeting_agenda_author_field);
        final ContentLoadingProgressBar progressBar = findViewById(R.id.create_meeting_agenda_loading_progress);
        final Button createMeetingAgenda = findViewById(R.id.create_meeting_agenda_button);

        final CreateMeetingAgendaViewModel viewModel = new CreateMeetingAgendaViewModel();
        author.setText(viewModel.getCurrentUser().getName());

        createMeetingAgenda.setEnabled(false);
        createMeetingAgenda.getBackground().setAlpha(50);
        createMeetingAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                viewModel.createMeetingAgenda(
                  title.getText().toString(),
                  description.getText().toString(),
                  details.getText().toString()
                ).observe(CreateMeetingAgendaPage.this, new Observer<CreateMeetingAgendaResponse>() {
                    @Override
                    public void onChanged(CreateMeetingAgendaResponse createMeetingAgendaResponse) {
                        progressBar.setVisibility(View.GONE);
                        if(
                          createMeetingAgendaResponse.getCreatedMeetingAgendaSuccessfully() != null &&
                          createMeetingAgendaResponse.getCreatedMeetingAgendaSuccessfully()
                        ){
                          Toast.makeText(getApplicationContext(),"A pauta "+title.getText().toString()+" foi criada com sucesso", Toast.LENGTH_LONG).show();
                          finish();
                        }else{
                          if(createMeetingAgendaResponse.getUnexpectedError() != null && createMeetingAgendaResponse.getUnexpectedError()) {
                              Toast.makeText(getApplicationContext(),createMeetingAgendaResponse.getUnexpectedErrorMessage(), Toast.LENGTH_LONG).show();
                          }else{
                              title.setError(createMeetingAgendaResponse.getTitleErrorMessage());
                              description.setError(createMeetingAgendaResponse.getDescriptionErrorMessage());
                              details.setError(createMeetingAgendaResponse.getDetailsErrorMessage());
                              author.setError(createMeetingAgendaResponse.getAuthorErrorMessage());
                          }
                        }
                    }
                });
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(title.getText().toString().isEmpty() || description.getText().toString().isEmpty()
                        || details.getText().toString().isEmpty()) {
                    createMeetingAgenda.setEnabled(false);
                    createMeetingAgenda.getBackground().setAlpha(50);
                }else{
                    createMeetingAgenda.setEnabled(true);
                    createMeetingAgenda.getBackground().setAlpha(255);
                }
            }
        };
        title.addTextChangedListener(textWatcher);
        description.addTextChangedListener(textWatcher);
        details.addTextChangedListener(textWatcher);

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
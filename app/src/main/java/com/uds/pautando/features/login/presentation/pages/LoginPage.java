package com.uds.pautando.features.login.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;

import com.uds.pautando.R;
import com.uds.pautando.features.login.data.model.LoginResponse;
import com.uds.pautando.features.login.presentation.viewmodel.LoginViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Button login = findViewById(R.id.login);
        final EditText emailEdt = findViewById(R.id.email);
        final EditText passwordEdt = findViewById(R.id.password);

        final LoginViewModel loginViewModel = new LoginViewModel();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.login(emailEdt.getText().toString(),passwordEdt.getText().toString())
                        .observe(LoginPage.this, new Observer<LoginResponse>() {
                            @Override
                            public void onChanged(LoginResponse loginResponse) {
                                Log.i("RESULT",loginResponse.toString());
                            }
                        });
            }
        });
    }
}
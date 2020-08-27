package com.uds.pautando.features.sign_in.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;

import com.uds.pautando.R;
import com.uds.pautando.core.preferences.MyPreferences;
import com.uds.pautando.features.home.presentation.pages.HomeActivity;
import com.uds.pautando.features.sign_in.data.model.LoginResponse;
import com.uds.pautando.features.sign_in.presentation.viewmodel.LoginViewModel;
import com.uds.pautando.features.sign_up.presentation.pages.SignUpPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        MyPreferences.getInstance(getApplicationContext());

        final Button login = findViewById(R.id.login);
        final Button signup = findViewById(R.id.signup);

        final EditText emailEdt = findViewById(R.id.email);
        final EditText passwordEdt = findViewById(R.id.password);

        final ContentLoadingProgressBar loading = findViewById(R.id.login_loading_progress);

        final LoginViewModel loginViewModel = new LoginViewModel();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SignUpPage.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE);
                loginViewModel.login(emailEdt.getText().toString(),passwordEdt.getText().toString())
                        .observe(LoginPage.this, new Observer<LoginResponse>() {
                            @Override
                            public void onChanged(LoginResponse loginResponse) {
                                loading.setVisibility(View.GONE);
                                Log.i("LOGIN RESULT",loginResponse.toString());
                                if(
                                  loginResponse.getUserLoggedInSuccessfully() != null
                                  && loginResponse.getUserLoggedInSuccessfully()
                                ) {
                                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                                    startActivity(intent);
                                }else{
                                    if(loginResponse.getUnexpectedError()) {
                                        Toast.makeText(getBaseContext(),loginResponse.getUnexpectedErrorMessage(),Toast.LENGTH_LONG).show();
                                    }else{
                                        emailEdt.setError(loginResponse.getEmailErrorMessage());
                                        passwordEdt.setError(loginResponse.getPasswordErrorMessage());
                                    }
                                }
                            }
                        });
            }
        });
    }
}
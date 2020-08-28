package com.uds.pautando.features.sign_in.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;

import com.uds.pautando.R;
import com.uds.pautando.core.preferences.MyPreferences;
import com.uds.pautando.features.forgot_password.presentation.pages.ForgotPasswordPage;
import com.uds.pautando.features.home.presentation.pages.HomeActivity;
import com.uds.pautando.features.sign_in.data.model.SignInResponse;
import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.presentation.viewmodel.CurrentUserViewModel;
import com.uds.pautando.features.sign_in.presentation.viewmodel.LoginViewModel;
import com.uds.pautando.features.sign_up.presentation.pages.SignUpPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        MyPreferences.getInstance(getApplicationContext());

        final Button login = findViewById(R.id.signIn);
        final Button signup = findViewById(R.id.signup);

        final EditText emailEdt = findViewById(R.id.email);
        final EditText passwordEdt = findViewById(R.id.password);

        LinearLayout goToForgorPassword = findViewById(R.id.go_to_forgot_password);

        final ContentLoadingProgressBar loading = findViewById(R.id.signin_loading_progress);

        final LoginViewModel loginViewModel = new LoginViewModel();
        final CurrentUserViewModel currentUserViewModel = new CurrentUserViewModel();

        currentUserViewModel.getUserMutableLiveData().observe(SignInPage.this, new Observer<SignInUser>() {
            @Override
            public void onChanged(SignInUser signInUser) {
                if(signInUser != null) {
                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        currentUserViewModel.init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SignUpPage.class);
                startActivity(intent);
            }
        });

        goToForgorPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ForgotPasswordPage.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE);
                loginViewModel.login(emailEdt.getText().toString(),passwordEdt.getText().toString())
                        .observe(SignInPage.this, new Observer<SignInResponse>() {
                            @Override
                            public void onChanged(SignInResponse signInResponse) {
                                loading.setVisibility(View.GONE);
                                Log.i("LOGIN RESULT", signInResponse.toString());
                                if(
                                  signInResponse.getUserLoggedInSuccessfully() != null
                                  && signInResponse.getUserLoggedInSuccessfully()
                                ) {
                                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    if(signInResponse.getUnexpectedError()) {
                                        Toast.makeText(getBaseContext(), signInResponse.getUnexpectedErrorMessage(),Toast.LENGTH_LONG).show();
                                    }else{
                                        emailEdt.setError(signInResponse.getEmailErrorMessage());
                                        passwordEdt.setError(signInResponse.getPasswordErrorMessage());
                                    }
                                }
                            }
                        });
            }
        });
    }
}
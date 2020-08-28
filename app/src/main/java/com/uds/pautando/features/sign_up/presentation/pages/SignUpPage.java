package com.uds.pautando.features.sign_up.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;

import com.uds.pautando.R;
import com.uds.pautando.features.home.presentation.pages.HomeActivity;
import com.uds.pautando.features.sign_in.presentation.pages.SignInPage;
import com.uds.pautando.features.sign_up.data.model.SignUpResponse;
import com.uds.pautando.features.sign_up.presentation.viewmodel.SignUpViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        ImageView back = findViewById(R.id.back);
        LinearLayout backToLogin = findViewById(R.id.back_to_login);
        final EditText edtName = findViewById(R.id.signup_name);
        final EditText edtEmail = findViewById(R.id.signup_email);
        final EditText edtPassword = findViewById(R.id.signup_password);
        final ContentLoadingProgressBar progressBar = findViewById(R.id.signup_loading_progress);
        final Button signUp = findViewById(R.id.signup);

        final SignUpViewModel signUpViewModel = new SignUpViewModel();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                signUpViewModel.signUp(
                  edtName.getText().toString(),
                  edtEmail.getText().toString(),
                  edtPassword.getText().toString()
                ).observe(SignUpPage.this, new Observer<SignUpResponse>() {
                    @Override
                    public void onChanged(SignUpResponse signUpResponse) {
                        progressBar.setVisibility(View.GONE);
                        if(signUpResponse.getSignUpSuccessfully()) {
                            Toast.makeText(getApplicationContext(),"Sua conta foi criada com sucesso",Toast.LENGTH_LONG).show();
                            finish();
                        }else{
                            if(signUpResponse.getUnexpectedError()) {
                                Toast.makeText(getApplicationContext(),signUpResponse.getUnexpectedErrorMessage(),Toast.LENGTH_LONG).show();
                            }else{
                                edtName.setError(signUpResponse.getNameErrorMessage());
                                edtEmail.setError(signUpResponse.getEmailErrorMessage());
                                edtPassword.setError(signUpResponse.getPasswordErrorMessage());
                            }
                        }
                    }
                });
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });
    }
}
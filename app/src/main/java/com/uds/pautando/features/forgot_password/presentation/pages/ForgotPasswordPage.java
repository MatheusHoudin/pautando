package com.uds.pautando.features.forgot_password.presentation.pages;
import com.uds.pautando.R;
import com.uds.pautando.features.forgot_password.data.model.RecoverPasswordResponse;
import com.uds.pautando.features.forgot_password.presentation.viewmodel.ForgotPasswordViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ForgotPasswordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page);

        ImageView back = findViewById(R.id.back_recover_password);
        LinearLayout backToLogin = findViewById(R.id.back_to_login);
        Button recoverPassword = findViewById(R.id.recover_password);
        final EditText edtEmail = findViewById(R.id.email_recover_password);
        final ContentLoadingProgressBar progressBar = findViewById(R.id.recover_password_loading_progress);

        final ForgotPasswordViewModel viewModel = new ForgotPasswordViewModel();

        recoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                viewModel.recoverPassword(edtEmail.getText().toString()).observe(ForgotPasswordPage.this, new Observer<RecoverPasswordResponse>() {
                    @Override
                    public void onChanged(RecoverPasswordResponse recoverPasswordResponse) {
                        progressBar.setVisibility(View.GONE);
                        if(recoverPasswordResponse.getEmailWasSentSuccessfully()) {
                            Toast.makeText(getBaseContext(),"Sucesso, enviamos um link de recuperação da sua senha para seu email", Toast.LENGTH_LONG).show();
                        }else{
                            if(recoverPasswordResponse.getUnexpectedError()) {
                                Toast.makeText(getBaseContext(),recoverPasswordResponse.getUnexpectedErrorMessage(), Toast.LENGTH_LONG).show();
                            }else{
                                edtEmail.setError(recoverPasswordResponse.getEmailErrorMessage());
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
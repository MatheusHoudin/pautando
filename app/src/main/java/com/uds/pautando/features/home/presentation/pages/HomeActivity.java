package com.uds.pautando.features.home.presentation.pages;

import androidx.appcompat.app.AppCompatActivity;
import com.uds.pautando.R;
import com.uds.pautando.core.preferences.MyPreferences;
import com.uds.pautando.features.sign_in.data.model.User;

import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User user = MyPreferences.getInstance().getUser();
        Log.i("UID", user.getUid());
        Log.i("EMAIL", user.getEmail());
    }
}
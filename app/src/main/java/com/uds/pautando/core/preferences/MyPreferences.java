package com.uds.pautando.core.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.uds.pautando.features.sign_in.data.model.SignInUser;

public class MyPreferences {
    static MyPreferences instance;
    SharedPreferences sharedPreferences;

    final static String UID = "UID";
    final static String EMAIL = "EMAIL";
    final static String NAME = "NAME";

    final static String PAUTANDOPREFERENCES = "PAUTANDOPREFERENCES";
    private Context context;

    public static MyPreferences getInstance(Context context) {
        if(instance == null) {
            instance = new MyPreferences(context);
        }
        return instance;
    }

    public static MyPreferences getInstance() {
        return instance;
    }

    private MyPreferences(Context context){
      this.context = context;
      this.sharedPreferences = context.getSharedPreferences(PAUTANDOPREFERENCES, Context.MODE_PRIVATE);
    }

    public void saveUserData(String uid, String name, String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UID, uid);
        editor.putString(EMAIL, email);
        editor.putString(NAME, name);
        editor.apply();
    }

    public SignInUser getUser() {
        String uid = sharedPreferences.getString(UID,null);
        String email = sharedPreferences.getString(EMAIL, null);
        String name = sharedPreferences.getString(NAME, null);

        return uid != null ? new SignInUser(uid,email,name) : null;
    }

}

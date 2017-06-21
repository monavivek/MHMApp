package com.example.monagarg.mhmapp.fcm;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.monagarg.mhmapp.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by monagarg on 13/06/17.
 */

public class FcmInstanceIdService extends FirebaseInstanceIdService{

    @Override
    public void onTokenRefresh() {

        String recant_token = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(getString(R.string.FCM_TOKEN),recant_token);
        editor.commit();
    }
}

package com.example.monagarg.mhmapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Broadcast extends AppCompatActivity implements View.OnClickListener {
    Button sub;
    String app_server_url="http://dhca.esy.es/fcm.php";
  //  TextView event;

    void initview()
    {
        sub=(Button)findViewById(R.id.Notification);
      //  sub.setOnClickListener(this);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
            initview();
    }


    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        final String token=sharedPreferences.getString(getString(R.string.FCM_TOKEN)," ");
        StringRequest stringRequest=new StringRequest(Request.Method.POST, app_server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<String, String>();
                params.put("fcm_token",token);
                return params;
            }
        };
        Mysingleton.getmInstance(Broadcast.this).addToRequestQueue(stringRequest);


    }
}
package com.example.monagarg.mhmapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by monagarg on 13/06/17.
 */

public class Mysingleton {

    private static Mysingleton mInstance;
    private  static Context mctx;
    private RequestQueue requestQueue;

    private Mysingleton(Context context)
    {
        mctx=context;
        requestQueue=getRequestQueue();

    }


    private RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized  Mysingleton getmInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance=new Mysingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestQueue(Request<T> request)
    {
        getRequestQueue().add(request);
    }
}


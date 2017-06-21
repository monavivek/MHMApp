package com.example.monagarg.mhmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.HashMap;

public class Gallary extends AppCompatActivity  {
    GridView gridview;
    HashMap<String,String> Hash_file_maps ;

            int[] mThumbIds = {
            R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten,
            R.drawable.eleven, R.drawable.tweleve,
            R.drawable.icon,  R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        gridview = (GridView) findViewById(R.id.gridview);
       gridview.setAdapter(new ImageAdapter(this,mThumbIds));
        Hash_file_maps = new HashMap<String, String>();




    }
}

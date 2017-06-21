package com.example.monagarg.mhmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    TextView contact,contactnumber,contactname;

    void initview()
    {
        contact=(TextView)findViewById(R.id.contact);
        contactnumber=(TextView)findViewById(R.id.contactnumber);
        contactname=(TextView)findViewById(R.id.contactname);
        contact.setText("Kindly Contac Us");
        contactname.setText("1."+"Bharratpal Singh \n"+" +91-9780743786 \n\n"+"2."+" Sukhjinder Singh\n"+
                "+91-8146158809 \n\n"+"3."+"Barinder Singh\n"+"+91-9915864327 \n\n"+"4."+"Varun Bagga\n"+
                "+91-9781370806 \n\n"+"5."+"Kamaljit Singh\n"+" +91-9988710056 \n\n");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        initview();
    }
}

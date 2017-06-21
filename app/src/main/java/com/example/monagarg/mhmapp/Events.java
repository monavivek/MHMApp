package com.example.monagarg.mhmapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class Events extends AppCompatActivity {
    TextView date,time;
    Button submitDate,submitTime,submit;
    EditText Multitext;
    void initview()
    {
        date=(TextView) findViewById(R.id.date);
        time=(TextView) findViewById(R.id.time);
        Multitext=(EditText)findViewById(R.id.message);

        submitDate=(Button)findViewById(R.id.datebtn);
        submitTime=(Button)findViewById(R.id.timebtn);
        submit=(Button)findViewById(R.id.submit);
        Intent rcv1=getIntent();
        String re=rcv1.getStringExtra("result");
        String result1=rcv1.getStringExtra("rslt");
        Multitext.setText(" "+result1);
    }

    DatePickerDialog datePickerDialog;

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            date.setText(i+" / "+i1+" / "+i2);
          //  Multitext.setText(i+" / "+i1+" / "+i2+"\n");
        }
    };

    TimePickerDialog timePickerDialog;
    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            time.setText(i+" : "+i1);
           // Multitext.setText(" "+i+ ":"+i1);
        }
    };

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.datebtn){
                showDatePickerDialog();

            }
            if(view.getId()==R.id.timebtn){
                showTimePickerDialog();

            }
            if(view.getId()==R.id.submit)
            {
                Intent intent=new Intent(Events.this,Broadcast.class);
                startActivity(intent);
            }
        }
    };

    void showDatePickerDialog(){

        Calendar calendar = Calendar.getInstance();
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int mm = calendar.get(Calendar.MONTH);
        int yy = calendar.get(Calendar.YEAR);

        datePickerDialog= new DatePickerDialog(this,dateSetListener,yy,mm,dd);
        datePickerDialog.show();
    }

    void showTimePickerDialog(){

        Calendar calendar = Calendar.getInstance();
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this,timeSetListener,hh,mm,true);
        timePickerDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initview();
        submitDate.setOnClickListener(clickListener);
        submitTime.setOnClickListener(clickListener);
        submit.setOnClickListener(clickListener);

    }
}

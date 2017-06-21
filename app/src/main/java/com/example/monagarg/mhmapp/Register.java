package com.example.monagarg.mhmapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    
    StringRequest stringRequest;
    RequestQueue requestQueue;
    String gender;
    String desig;
    TextView details,DOB;
    EditText name, phone, email;
    RadioButton male, female;
    Spinner designation;
    Button register,dateofbirth;
    ArrayAdapter<String> desiganationAdapter;
    DatePickerDialog datePickerDialog;
    ProgressDialog progressDialog;


    void initview() {
        details = (TextView) findViewById(R.id.details);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        dateofbirth=(Button)findViewById(R.id.dateofbirth);
        DOB=(TextView)findViewById(R.id.DOB);
       // password = (EditText) findViewById(R.id.password);

        male = (RadioButton) findViewById(R.id.rbMale);
        female = (RadioButton) findViewById(R.id.rbMale);
        register = (Button) findViewById(R.id.submit);
        requestQueue= Volley.newRequestQueue(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait..");
        progressDialog.setCancelable(false);

      //  register.setOnClickListener(this);
        male.setOnCheckedChangeListener(this);
        female.setOnCheckedChangeListener(this);

    }

    DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override

        public void onDateSet(DatePicker datePicker, int i1, int i2, int i3) {
            int mm=i2+1;


            DOB.setText(i1+" / "+mm+" / "+i3);

        }
    };

    void showDatePickerDialog()
    {

        Calendar calendar=Calendar.getInstance();
       // calendar.set(1980,Calendar.JANUARY,1,0,0,0);
        int dd=calendar.get(calendar.DAY_OF_MONTH);
        int mm=calendar.get(calendar.MONTH);
        int yy=calendar.get(calendar.YEAR);
        datePickerDialog=new DatePickerDialog(this,dateSetListener,dd,mm,yy);
        datePickerDialog.show();
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.dateofbirth)
            {
                showDatePickerDialog();
            }
        }
    };
    void initspinner(){
        designation=(Spinner)findViewById(R.id.spiner);
        desiganationAdapter = new ArrayAdapter<String>(Register.this, android.R.layout.simple_list_item_1);

        desiganationAdapter.add("---Designation---");
        desiganationAdapter.add("Chairman");
        desiganationAdapter.add("President");
        desiganationAdapter.add("Sr.Vice President");
        desiganationAdapter.add("Vice President");
        desiganationAdapter.add("Cashier");
        desiganationAdapter.add("Executive Member");
        desiganationAdapter.add("Sewadaar");
        designation.setAdapter(desiganationAdapter);
      designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                desig = desiganationAdapter.getItem(i);

                switch (adapterView.getId()) {

                    case R.id.spiner:
//                        Toast.makeText(Register.this,"You Selected " +desig,Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initview();
        dateofbirth.setOnClickListener(clickListener);
        initspinner();
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id=compoundButton.getId();
        switch (id)
        {
            case R.id.rbMale:
                if(b)
                {
//                    Toast.makeText(Register.this,"Male Checked",Toast.LENGTH_LONG).show();
                    gender="male";
                }
                else {
//                    Toast.makeText(Register.this,"Female Checked",Toast.LENGTH_LONG).show();
                    gender="female";
                }
        }



    }

    public void registerHandler(View view){
        progressDialog.show();

        stringRequest=new StringRequest(Request.Method.POST, "http://dhca.esy.es/register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        Log.i("response",s);

                        try {
                            JSONObject jsonObject=new JSONObject(s);

                          //  JSONParser parser = new JSONParser();
                         //   JSONObject json = (JSONObject) parser.parse(stringToParse);
//                            JSONArray jsonArray=jsonObject.getJSONArray("ok");
//                            JSONArray jsonArray=jsonObject.getJSONArray("ok");
//
//                            for (int i=0;i<jsonArray.length();i++){
//                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
//                                if (jsonObject1.getInt("success")==1){
//
//                                    Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
//                                }
//                            }


                           Log.i("S",String.valueOf(jsonObject.getInt("success")));
                            if (jsonObject.getInt("success")==1)
                            {
                                Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();startActivity(new Intent(Register.this,MainActivity.class));
                                progressDialog.dismiss();
                            }
                            else if(jsonObject.getInt("success")==2){
                                Toast.makeText(Register.this,desig+" already  Registered",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(Register.this,"Try Again Later",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Log.i("volley",volleyError.toString());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                //map.put("name",name.getText().toString());
                if (desig.equalsIgnoreCase("Executive Member") || desig.equalsIgnoreCase("Sewadaar"))
                    map.put("signal","1");
                else
                    map.put("signal","2");

                map.put("phone",phone.getText().toString());
                map.put("dob",DOB.getText().toString());
                map.put("email",email.getText().toString());
         //   map.put("password",password.getText().toString());
                map.put("gender",gender);
                map.put("designation",desig);
                Log.i("gg",map.toString());
                return map;

            }
        };
        requestQueue.add(stringRequest);

    }
}




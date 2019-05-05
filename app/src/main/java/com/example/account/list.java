package com.example.account;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class list extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    Calendar c=Calendar.getInstance();
    TextView textView18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        textView18 = (TextView)findViewById(R.id.textView18);
        textView18.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==textView18){
            new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textView18.setText(year+"/"+month+"/"+dayOfMonth);
    }
    public void fin(View v){
        finish();
    }
}

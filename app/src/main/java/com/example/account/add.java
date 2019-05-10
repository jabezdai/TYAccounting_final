package com.example.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class add extends AppCompatActivity {
    Calendar c=Calendar.getInstance();
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        textView2= (TextView)findViewById(R.id.textView2);
        int nowyear = c.get(Calendar.YEAR);
        int nowmonth = c.get(Calendar.MONTH);
        int nowday = c.get(Calendar.DAY_OF_MONTH);
        nowmonth=nowmonth+1;
        textView2.setText(nowyear+"/"+nowmonth+"/"+nowday);
    }
    public void fin(View v){
        finish();
    }
    public void back(View v){
        finish();
    }
}

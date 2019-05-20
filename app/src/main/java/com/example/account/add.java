package com.example.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class add extends AppCompatActivity {
    Calendar c=Calendar.getInstance();
    TextView textView2;


    EditText name;
    EditText money;
    EditText time;
    EditText place;
    Spinner type;
    Spinner payway;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent it1 = getIntent();

        name = (EditText)findViewById(R.id.name);
        money = (EditText)findViewById(R.id.money);
        time  = (EditText)findViewById(R.id.time);
        place = (EditText)findViewById(R.id.place);
        type = (Spinner)findViewById(R.id.type);
        payway = (Spinner)findViewById(R.id.payway);

        textView2= (TextView)findViewById(R.id.textView2);
        int nowyear = c.get(Calendar.YEAR);
        int nowmonth = c.get(Calendar.MONTH);
        int nowday = c.get(Calendar.DAY_OF_MONTH);
        nowmonth=nowmonth+1;
        textView2.setText(nowyear+"/"+nowmonth+"/"+nowday);
    }
    public void fin(View v){

        Intent it = new Intent();
        String [] Type = getResources().getStringArray(R.array.type);
        int index = type.getSelectedItemPosition();

        String [] Payway = getResources().getStringArray(R.array.payway);
        int index1 = payway.getSelectedItemPosition();

        it.putExtra("內容",name.getText().toString()+"                                                   "+money.getText().toString());
        it.putExtra("名稱",name.getText().toString());
        it.putExtra("支出",money.getText().toString());
        it.putExtra("時間",time.getText().toString());
        it.putExtra("地點",place.getText().toString());
        it.putExtra("類別",Type[index]);
        it.putExtra("方式",Payway[index]);



        setResult(RESULT_OK,it);
        finish();
    }
    public void back(View v)
    {
        finish();
    }
}

package com.example.account;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class add extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener{
    Calendar c=Calendar.getInstance();
    TextView textView2;
    TextView time;


    EditText name;
    EditText money;
    EditText place;
    Spinner type;
    Spinner payway;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent it1 = getIntent();

        name = (EditText)findViewById(R.id.name);
        money = (EditText)findViewById(R.id.money);
        place = (EditText)findViewById(R.id.place);
        type = (Spinner)findViewById(R.id.type);
        payway = (Spinner)findViewById(R.id.payway);

        textView2= (TextView)findViewById(R.id.textView2);
        time= (TextView)findViewById(R.id.time);
        time.setOnClickListener(this);
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

        it.putExtra("名稱",name.getText().toString());
        it.putExtra("支出",money.getText().toString());
        it.putExtra("時間",time.getText().toString());
        it.putExtra("地點",place.getText().toString());
        it.putExtra("類別",Type[index]);
        it.putExtra("方式",Payway[index]);


        if(name.length()==0){
            Toast toast = Toast.makeText(this,"名稱為必填欄位",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM,0,200);
            toast.show();
        }else if(money.length()==0){
            Toast toast = Toast.makeText(this,"支出為必填欄位",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM,0,200);
            toast.show();
        }else {
            setResult(RESULT_OK, it);
            finish();
        }
    }
    public void back(View v)
    {
        finish();
    }
    @Override
    public void onClick(View v) {
        if(v==time){
            new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month=month+1;
        if(month<10&&dayOfMonth<10)
            time.setText(year+"0"+month+"0"+dayOfMonth);
        else if(month>10&&dayOfMonth<10)
            time.setText(year+""+month+"0"+dayOfMonth);
        else if(month<10&&dayOfMonth>10)
            time.setText(year+"0"+month+""+dayOfMonth);
        else time.setText(year+""+month+""+dayOfMonth);
    }


}

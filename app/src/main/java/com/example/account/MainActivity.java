package com.example.account;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Calendar c=Calendar.getInstance();
    static final String db_account="acDB";
    static final String tb_account="actb";
    SQLiteDatabase db;
    TextView textView;
    ListView lv;
    ArrayAdapter<String> aa;
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =openOrCreateDatabase(db_account, Context.MODE_PRIVATE,null);


        textView= (TextView)findViewById(R.id.textView);
        int nowyear = c.get(Calendar.YEAR);
        int nowmonth = c.get(Calendar.MONTH);
        int nowday = c.get(Calendar.DAY_OF_MONTH);
        nowmonth=nowmonth+1;
        textView.setText(nowyear+"/"+nowmonth+"/"+nowday);


    }
    private void addData(String name,String money,String time,String place,String type,String payway){
        ContentValues cv=new ContentValues(6);
        cv.put("名稱",name);
        cv.put("支出",money);
        cv.put("時間",time);
        cv.put("地點",place);
        cv.put("類別",type);
        cv.put("方式",payway);
        db.insert(tb_account,null,cv);
    }

    public void add(View v){
        Intent itadd = new Intent(this,add.class);

        startActivityForResult(itadd,index);
    }

    public void data(View v) {
        Intent itdata = new Intent(this, data.class);

        startActivity(itdata);
    }
    public void personal(View v) {
        Intent itpersonal = new Intent(this,activity_personal.class);

        startActivity(itpersonal);
    }
    public void listl(View v) {
        Intent itlist = new Intent(this,list.class);

        startActivity(itlist);
    }

    protected void onActivityResult(int requestcode,int resultcode,Intent itadd){
        if(resultcode==RESULT_OK){
            addData(itadd.getStringExtra("名稱"),itadd.getStringExtra("支出"),itadd.getStringExtra("時間"),itadd.getStringExtra("地點"),itadd.getStringExtra("類別"),itadd.getStringExtra("方式"));
        }
    }

}

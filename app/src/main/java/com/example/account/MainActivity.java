package com.example.account;

import android.content.Intent;
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
    TextView textView;
    String[] aMemo ={"1"};
    ListView lv;
    ArrayAdapter<String> aa;
    int index ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 0;

        textView= (TextView)findViewById(R.id.textView);
        int nowyear = c.get(Calendar.YEAR);
        int nowmonth = c.get(Calendar.MONTH);
        int nowday = c.get(Calendar.DAY_OF_MONTH);
        nowmonth=nowmonth+1;
        textView.setText(nowyear+"/"+nowmonth+"/"+nowday);

        lv = (ListView)findViewById(R.id.lv);
        aa = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,aMemo);
        lv.setAdapter(aa);
    }

    public void add(View v){
        Intent itadd = new Intent(this,add.class);

        itadd.putExtra("內容",aMemo[index]);
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
            aMemo[index] = itadd.getStringExtra("內容");
        }
        aa.notifyDataSetChanged();
    }

}

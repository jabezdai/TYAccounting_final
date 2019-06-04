package com.example.account;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Calendar c=Calendar.getInstance();
    static final String db_account="acDB";
    static final String table_account="actb";
    static final String[] FROM = new String[]{"名稱","支出","時間","地點","類別","方式"};
    SQLiteDatabase db;
    android.database.Cursor cursor;
    private SimpleAdapter adapter;
    private List<Map<String,Object>> mData;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int one;
        db = openOrCreateDatabase(db_account, Context.MODE_PRIVATE, null);
        String CREAT_SQL = "CREATE TABLE IF NOT EXISTS " + table_account + "(名稱 VARCHER(32)," + "支出 VARCHER(32)," + "時間 VARCHER(32)," + "地點 VARCHER(32)," + "類別 VARCHER(32)," + "方式 VARCHER(32))";
        db.execSQL(CREAT_SQL);
        cursor = db.rawQuery("SELECT * FROM " + table_account, null);
        mData = new ArrayList<Map<String, Object>>();
        Map<String, Object> itemData = null;
        cursor.moveToFirst();
        itemData = new HashMap<String, Object>();
        itemData.put("名稱",cursor.getString(cursor.getColumnIndex("名稱")));
        itemData.put("支出",cursor.getString(cursor.getColumnIndex("支出")));
        itemData.put("時間",cursor.getString(cursor.getColumnIndex("時間")));
        mData.add(itemData);
        while (cursor.moveToNext()) {
            itemData = new HashMap<String, Object>();
            itemData.put("名稱",cursor.getString(cursor.getColumnIndex("名稱")));
            itemData.put("支出",cursor.getString(cursor.getColumnIndex("支出")));
            itemData.put("時間",cursor.getString(cursor.getColumnIndex("時間")));
            mData.add(itemData);
        };
        adapter = new SimpleAdapter(this, mData, R.layout.accountlist, new String[]{"名稱", "支出", "時間"}, new int[]{R.id.textView23, R.id.textView21, R.id.textView22});
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);


        textView = (TextView) findViewById(R.id.textView);
        int nowyear = c.get(Calendar.YEAR);
        int nowmonth = c.get(Calendar.MONTH);
        int nowday = c.get(Calendar.DAY_OF_MONTH);
        nowmonth = nowmonth + 1;
        textView.setText(nowyear + "/" + nowmonth + "/" + nowday);


    }


    private void addData(String name,String money,String time,String place,String type,String payway){
        ContentValues cv=new ContentValues(6);
        cv.put("名稱",name);
        cv.put("支出",money);
        cv.put("時間",time);
        cv.put("地點",place);
        cv.put("類別",type);
        cv.put("方式",payway);
        db.insert(table_account,null,cv);
    }

    public void add(View v){
        Intent itadd = new Intent(this,add.class);

        startActivityForResult(itadd,1);
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
        TextView name =(TextView)findViewById(R.id.textView34);
        TextView money =(TextView)findViewById(R.id.textView35);
        TextView time =(TextView)findViewById(R.id.textView36);
        TextView place =(TextView)findViewById(R.id.textView37);
        TextView type =(TextView)findViewById(R.id.textView38);
        TextView payway =(TextView)findViewById(R.id.textView39);
        if(resultcode==RESULT_OK){
            name.setText(itadd.getStringExtra("名稱"));
            money.setText(itadd.getStringExtra("支出"));
            time.setText(itadd.getStringExtra("時間"));
            place.setText(itadd.getStringExtra("地點"));
            payway.setText(itadd.getStringExtra("方式"));
            type.setText(itadd.getStringExtra("類別"));
            addData(itadd.getStringExtra("名稱"),itadd.getStringExtra("支出"),itadd.getStringExtra("時間"),itadd.getStringExtra("地點"),itadd.getStringExtra("類別"),itadd.getStringExtra("方式"));
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cursor.moveToPosition(position);
        TextView name =(TextView)findViewById(R.id.textView34);
        TextView money =(TextView)findViewById(R.id.textView35);
        TextView time =(TextView)findViewById(R.id.textView36);
        TextView place =(TextView)findViewById(R.id.textView37);
        TextView type =(TextView)findViewById(R.id.textView38);
        TextView payway =(TextView)findViewById(R.id.textView39);
        name.setText(cursor.getString(cursor.getColumnIndex(FROM[0])));
        money.setText(cursor.getString(cursor.getColumnIndex(FROM[1])));
        time.setText(cursor.getString(cursor.getColumnIndex(FROM[2])));
        place.setText(cursor.getString(cursor.getColumnIndex(FROM[3])));
        type.setText(cursor.getString(cursor.getColumnIndex(FROM[4])));
        payway.setText(cursor.getString(cursor.getColumnIndex(FROM[5])));
    }
}

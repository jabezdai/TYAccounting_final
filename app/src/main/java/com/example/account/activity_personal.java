package com.example.account;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class activity_personal extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    static final String DB_NAME="dollarDB";
    static final String TB_NAME="dollarlist";
    static final int MAX = 10;
    static final String[] FROM = new String[] {"name","money"};
    SQLiteDatabase db;
    Cursor cur;
    SimpleCursorAdapter adapter;
    EditText money;
    ListView lv;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE,null);

        String createTable = "CREAT TABLE IF NOT EXISTS" + TB_NAME
                                +"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                +"(name VARCHAR(16),"
                                +"money VARCHAR(16))";
        db.execSQL(createTable);

        cur = db.rawQuery("SELECT*FROM" + TB_NAME,null);

        if(cur.getCount() == 0){
            addDATA("現金",0);
            addDATA("悠悠卡",0);
            addDATA("點點卡",0);
            addDATA("信用卡",0);
        }

        adapter = new SimpleCursorAdapter(this,R.layout.personal_list,cur,FROM, new int[]{R.id.name,R.id.money},0);
        lv = (ListView) findViewById(R.id.plv);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(this);
    }
    private void addDATA(String name,int money){
        ContentValues cv = new ContentValues(2);
        cv.put(FROM[0],name);
        cv.put(FROM[1],money);

        db.insert(TB_NAME,null,cv);
    }
    private void update(int money,int id){
        ContentValues cv = new ContentValues(1);
        cv.put(FROM[1],money);

        db.update(TB_NAME,cv,"_id="+id,null);
    }

    public boolean onItemLongClick(AdapterView<?> a,View v,int pos,long id){
        final int num = pos;


        AlertDialog.Builder input = new AlertDialog.Builder(this);



        input.setTitle("金額輸入");
        final EditText in = new EditText(this);
        in.setInputType(InputType.TYPE_CLASS_TEXT );
        input.setView(in);
        input.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            final EditText money = (EditText) findViewById(R.id.money);

            @Override
            public void onClick(DialogInterface dialog, int which) {
                int i = Integer.parseInt(in.getText().toString());
                update(i,num);

            }
        });
        input.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = input.create();
        dialog.show();
        return true;

    }



    public void fin(View v){
        finish();
    }
    public void group(View v) {
        Intent itgroup = new Intent(this,group.class);

        startActivity(itgroup);
    }
}

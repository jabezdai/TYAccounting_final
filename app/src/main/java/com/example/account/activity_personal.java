package com.example.account;

import android.content.DialogInterface;
import android.content.Intent;
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

public class activity_personal extends AppCompatActivity implements AdapterView.OnItemLongClickListener {


    String[] Memo={"現金","悠悠卡","點點卡","信用卡"};
    ListView lv;
    ArrayAdapter<String> aa;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        lv = (ListView) findViewById(R.id.plv);
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Memo);
        lv.setAdapter(aa);
        lv.setOnItemLongClickListener(this);
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


                Memo[num] =Memo[num]+ "                                                                            "+in.getText().toString();
                aa.notifyDataSetChanged();

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

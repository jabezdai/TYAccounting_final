package com.example.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class group extends AppCompatActivity {
    public static final String FAMILY_NO="family_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ListView lvfamily = this.findViewById(R.id.family_dynamic);

        ArrayList<String>familylist = new ArrayList<String>();

        familylist.add("Dad");
        familylist.add("Mom");

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,familylist);
        lvfamily.setAdapter(adapter);

        lvfamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(group.this, family.class);
                intent.putExtra(FAMILY_NO, position);
                startActivity(intent);

            }
        });

    }
    public void fin(View v){
        finish();
    }


}

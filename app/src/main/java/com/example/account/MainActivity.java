package com.example.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v){
        Intent itadd = new Intent(this,add.class);

        startActivity(itadd);
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

}

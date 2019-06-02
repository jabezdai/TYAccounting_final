package com.example.account;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_personal extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        EditText editText=(EditText) findViewById(R.id.editText);
        EditText editText2=(EditText) findViewById(R.id.editText2);
        EditText editText3=(EditText) findViewById(R.id.editText3);
        EditText editText4=(EditText) findViewById(R.id.editText4);
        editText.setText(sharedPreferences.getString("現金","0"));
        editText2.setText(sharedPreferences.getString("信用卡","0"));
        editText3.setText(sharedPreferences.getString("悠遊卡","0"));
        editText4.setText(sharedPreferences.getString("點點卡","0"));
    }
    public void fin(View v){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText editText=(EditText) findViewById(R.id.editText);
        EditText editText2=(EditText) findViewById(R.id.editText2);
        EditText editText3=(EditText) findViewById(R.id.editText3);
        EditText editText4=(EditText) findViewById(R.id.editText4);
        String cash=editText.getText().toString();
        String credit=editText2.getText().toString();
        String Lcard=editText3.getText().toString();
        String Mcard=editText4.getText().toString();
        editor.putString("現金",cash).putString("信用卡",credit).putString("悠遊卡",Lcard).putString("點點卡",Mcard).commit();
        finish();
    }
    public void group(View v) {
        Intent itgroup = new Intent(this,group.class);

        startActivity(itgroup);
    }
}

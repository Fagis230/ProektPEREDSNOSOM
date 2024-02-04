package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity2 extends AppCompatActivity {
    SQLiteDatabase sqlitedase2;
    public Button buttonans;
    public TextView textans;
    public TextView textresh;
    public TextView zadacha;
    public TextView zadachaid;
    public EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent Main2  = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonans = (Button) findViewById(R.id.buttonans);
        textans = (TextView) findViewById(R.id.textans);
        textresh  = (TextView) findViewById(R.id.textresh);
        zadacha = (TextView) findViewById(R.id.textzad);
        zadachaid = (TextView) findViewById(R.id.textid);
        answer = (EditText) findViewById(R.id.edittextans);
        zadachaid.setText(Main2.getStringExtra("id"));
        zadacha.setText(Main2.getStringExtra("zad"));
        textans.setText(Main2.getStringExtra("ans"));
        buttonans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans2 = answer.getText().toString();
                Log.d("mLog3","zadid= " + zadachaid + ", text="+zadacha+", ans="+textans);
            }
        });




    }
}
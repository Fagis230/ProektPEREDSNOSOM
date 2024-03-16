package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DinamicActivity2 extends AppCompatActivity {
    EditText editText2;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dinamic2);
        editText2 =findViewById(R.id.dinamicinput);
        button2 = findViewById(R.id.termo1_button);
        button3 = findViewById(R.id.button11);
        button3.setOnClickListener(new View.OnClickListener() {
            Intent inter2 = new Intent(DinamicActivity2.this,MainActivity4.class);
            @Override
            public void onClick(View view) {
                startActivity(inter2);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = editText2.getText().toString();
                if(s2.equals(String.valueOf("2,8"))){
                    Toast.makeText(DinamicActivity2.this,"Ответ верный",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DinamicActivity2.this,"Ответ неверный",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
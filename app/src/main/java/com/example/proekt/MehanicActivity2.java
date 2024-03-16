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

public class MehanicActivity2 extends AppCompatActivity {
    EditText editText;
    Button button;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mehanic2);
        editText =findViewById(R.id.mehanicinput);
        button4 = findViewById(R.id.button12);
        button = findViewById(R.id.mechanic1_button);
        button4.setOnClickListener(new View.OnClickListener() {
            Intent inter = new Intent(MehanicActivity2.this,MainActivity4.class);
            @Override
            public void onClick(View view) {
                startActivity(inter);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            String s2 = editText.getText().toString();
            @Override
            public void onClick(View view) {
                if(s2.equals(String.valueOf("1.0"))){
                    Toast.makeText(MehanicActivity2.this,"Ответ верный",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MehanicActivity2.this,"Ответ неверный",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
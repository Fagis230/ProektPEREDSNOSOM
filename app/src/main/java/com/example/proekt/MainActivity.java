package com.example.proekt;


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
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    private static final String DATABASE_NAME = "ZAD1.db";
    private static final String TABLE_NAME = "questions1";
    private static final String COLUMN_TEM = "TEM";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_TEXTZ = "TEXTZ";
    private static final String COLUMN_ANSWER = "ANSWER";
    private static final int DATABASE_VERSION  = 1;
    private Button button1;
    private Button button2;
    private String idText;
    private String textZAD;
    private String answerTEXT;

    String[] cn = null;
    Button button_edit;
    Button buttonid;
    EditText edit;
    EditText edit2;
    EditText edit3;
    EditText editid;
    SQLiteDatabase sqLiteDatabase;
    Button button_out;
    Button button_clear;
    String selection;
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        button_out = (Button) findViewById(R.id.outbtn);
        button_edit = (Button) findViewById(R.id.editbtn);
        button_clear = (Button) findViewById(R.id.clear);
        buttonid = (Button) findViewById(R.id.editbtnid);
        edit = (EditText) findViewById(R.id.edittext);
        edit2 = (EditText) findViewById(R.id.editanswer);
        edit3 = (EditText) findViewById(R.id.edittem);
        editid = (EditText) findViewById(R.id.edittextid);
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zad1 = edit.getText().toString();
                String answer1 = edit2.getText().toString();
                String tem1 = edit3.getText().toString();
                Log.d("mLog","id = " + zad1 +
                        ", text = " + answer1 + ",answer = "+
                        ",tem = "+ tem1);
                ContentValues contentValues = new ContentValues();
                switch (v.getId()) {
                    case R.id.editbtn:
                        contentValues.put(COLUMN_TEXTZ,zad1);
                        contentValues.put(COLUMN_ANSWER,answer1);
                        contentValues.put( COLUMN_TEM,tem1);
                        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
                        break;
                }
            }
        });
        button_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                switch (view1.getId()){
                    case  R.id.outbtn:
                        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
                        if (cursor.moveToFirst()){
                            int idIndex  = cursor.getColumnIndex(COLUMN_ID);
                            int textIndex  = cursor.getColumnIndex(COLUMN_TEXTZ);
                            int answerIndex  = cursor.getColumnIndex(COLUMN_ANSWER);
                            int temIndex  = cursor.getColumnIndex(COLUMN_TEM);
                            do {
                                Log.d("mLog","id = " + cursor.getInt(idIndex)+
                                        ", text = " + cursor.getString(textIndex) + ",answer = "+
                                        cursor.getString(answerIndex)+",tem = "+ cursor.getString(temIndex));
                            } while (cursor.moveToNext());
                        }
                        else
                            Log.d("mLog","0 rows");
                        cursor.close();
                        break;
                }

            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                switch(view2.getId()){
                    case R.id.clear:
                        sqLiteDatabase.delete(TABLE_NAME,null,null);
                        break;
                }

            }
        });
        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                Intent Main2 = new Intent(MainActivity.this,MainActivity2.class);

                switch (view3.getId()){
                    case R.id.editbtnid:
                        String id1 = editid.getText().toString();
                        cn = new String[]{id1};
                        selection = "id = ?";
                        Cursor cursor1 = sqLiteDatabase.query(TABLE_NAME, null, selection, cn, null, null, null);
                        if (cursor1.moveToFirst()){
                            int idIndex2  = cursor1.getColumnIndex(COLUMN_ID);
                            int textIndex2 = cursor1.getColumnIndex(COLUMN_TEXTZ);
                            int answerIndex2  = cursor1.getColumnIndex(COLUMN_ANSWER);
                            int temIndex2  = cursor1.getColumnIndex(COLUMN_TEM);
                            idText = cursor1.getString(idIndex2);
                            textZAD = cursor1.getString(textIndex2);
                            answerTEXT = cursor1.getString(answerIndex2);
                            Main2.putExtra("zad",textZAD);
                            Main2.putExtra("id",idText);
                            Main2.putExtra("ans",answerTEXT);
                            startActivity(Main2);

                            do {
                                Log.d("mLog2","id = " + cursor1.getInt(idIndex2)+
                                        ", text = " + cursor1.getString(textIndex2) + ",answer = "+
                                        cursor1.getString(answerIndex2)+",tem = "+ cursor1.getString(temIndex2));
                            } while (cursor1.moveToNext());
                        }
                        else
                            Log.d("mLog","0 rows");
                        cursor1.close();
                        break;
                }
            }
        });

    }
}
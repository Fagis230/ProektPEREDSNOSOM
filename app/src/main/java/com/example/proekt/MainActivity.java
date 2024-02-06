package com.example.proekt;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
import android.widget.FrameLayout;
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
    Button buttongroup;
    Button buttonadd;
    Button buttonprofile;
    FrameLayout frameLayout;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        editid = (EditText) findViewById(R.id.edittextid);
        buttonid = (Button) findViewById(R.id.editbtnid);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttongroup = (Button) findViewById(R.id.buttongr);
        buttonprofile= (Button) findViewById(R.id.buttonpr);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment blankFragment = new BlankFragment();
                FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,blankFragment);
                ft.commit();

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
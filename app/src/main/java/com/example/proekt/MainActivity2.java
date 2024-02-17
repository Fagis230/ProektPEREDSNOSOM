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
    private static final String DATABASE_NAME = "ZAD1.db";
    private static final String TABLE_NAME = "questions1";
    private static final String COLUMN_TEM = "TEM";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_TEXTZ = "TEXTZ";
    private static final String COLUMN_ANSWER = "ANSWER";
    private static final int DATABASE_VERSION  = 1;

    public Button buttonans;
    public TextView zadacha;
    public TextView zadachaid;
    public EditText answer;
    String[] cn2 = null;
    String selection2;
    DBHelper dbh;
    SQLiteDatabase sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent Main2  = getIntent();
        dbh = new DBHelper(this);
        sq  = dbh.getWritableDatabase();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonans = (Button) findViewById(R.id.buttonans);
        zadacha = (TextView) findViewById(R.id.textzad);
        zadachaid = (TextView) findViewById(R.id.textid);
        answer = (EditText) findViewById(R.id.edittextans);
        zadachaid.setText("Номер задачи:"+Main2.getStringExtra("id"));
        zadacha.setText(Main2.getStringExtra("zad"));
        String id2 = Main2.getStringExtra("id");
        Log.d("Abssss",id2);
        buttonans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans2 = answer.getText().toString();
                switch (view.getId()){
                    case R.id.buttonans:
                        cn2 = new String[]{id2};
                        selection2 = "id = ?";
                        Cursor cursor1 = sq.query(TABLE_NAME, null, selection2, cn2, null, null, null);
                        if(cursor1.moveToFirst()){
                            int ans = cursor1.getColumnIndex(COLUMN_ANSWER);
                            String otvet = cursor1.getString(ans);
                            Log.d("Abs2",otvet+ans2);
                            if (otvet.equals(ans2)){
                                Toast.makeText(MainActivity2.this,"Ответ верный",Toast.LENGTH_SHORT).show();
                            }
                            else Toast.makeText(MainActivity2.this,"Ответ неверный",Toast.LENGTH_SHORT).show();
                        }

                }


            }
        });




    }
}
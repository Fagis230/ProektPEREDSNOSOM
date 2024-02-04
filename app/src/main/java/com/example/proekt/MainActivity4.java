package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

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


public class MainActivity4 extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase1;
    String[] cn1 = null;
    String selection1;
    private String idText;
    private String textZAD;
    private String answerTEXT;
    private static final String DATABASE_NAME = "ZAD1.db";
    private static final String TABLE_NAME = "questions1";
    private static final String COLUMN_TEM = "TEM";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_TEXTZ = "TEXTZ";
    private static final String COLUMN_ANSWER = "ANSWER";
    private static final int DATABASE_VERSION  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DBHelper(this);
        sqLiteDatabase1 = dbHelper.getWritableDatabase();
        Button button1 = (Button) findViewById(R.id.termo1);
        Button button2 = (Button) findViewById(R.id.mehanic1);
        Button buttonid2= (Button) findViewById(R.id.editbtnid2);
        EditText editid2=(EditText) findViewById(R.id.edittextid2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Dinamic = new Intent(MainActivity4.this,DinamicActivity.class);
                startActivity(Dinamic);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mechanic = new Intent(MainActivity4.this,MechanicActivity.class);
                startActivity(Mechanic);


            }
        });
        buttonid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                Intent Main10 = new Intent(MainActivity4.this,MainActivity2.class);

                switch (view3.getId()){
                    case R.id.editbtnid2:
                        String id1 = editid2.getText().toString();
                        cn1 = new String[]{id1};
                        selection1 = "id = ?";
                        Cursor cursor1 = sqLiteDatabase1.query(TABLE_NAME, null, selection1, cn1, null, null, null);
                        if (cursor1.moveToFirst()){
                            int idIndex2  = cursor1.getColumnIndex(COLUMN_ID);
                            int textIndex2 = cursor1.getColumnIndex(COLUMN_TEXTZ);
                            int answerIndex2  = cursor1.getColumnIndex(COLUMN_ANSWER);
                            int temIndex2  = cursor1.getColumnIndex(COLUMN_TEM);
                            idText = cursor1.getString(idIndex2);
                            textZAD = cursor1.getString(textIndex2);
                            answerTEXT = cursor1.getString(answerIndex2);
                            Main10.putExtra("zad",textZAD);
                            Main10.putExtra("id",idText);
                            Main10.putExtra("ans",answerTEXT);
                            startActivity(Main10);
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
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  {

    private static final String DATABASE_NAME = "ZAD1.db";
    private static final String TABLE_NAME = "questions1";
    private static final String COLUMN_TEM = "TEM";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_TEXTZ = "TEXTZ";
    private static final String COLUMN_ANSWER = "ANSWER";
    private static final int DATABASE_VERSION  = 1;
    private static final String DATABASE_NAME1 = "info4";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXT";
    private static final String COlUMN_TASK = "Task";
    private static final String COlUMN_STATUS = "Status";
    private Button button1;
    private Button button2;
    private String idText;
    private String textZAD;
    private String answerTEXT;
    FloatingActionButton floatingActionButton;

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
    Button floating;
    DBHelperlog log;
    SQLiteDatabase sql3;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        log = new DBHelperlog(this);
        sql3 =log.getWritableDatabase();
        Intent Main = getIntent();
        String curlogin = Main.getStringExtra("curlogin");
        sqLiteDatabase = dbHelper.getWritableDatabase();
        editid = (EditText) findViewById(R.id.edittextid);
        buttonid = (Button) findViewById(R.id.editbtnid);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttongroup = (Button) findViewById(R.id.buttongr);
        buttonprofile= (Button) findViewById(R.id.buttonpr);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        buttonprofile.setOnClickListener(new View.OnClickListener() {
            Intent i = new Intent(MainActivity.this, MainActivity6.class);
            @Override
            public void onClick(View view) {
                i.putExtra("curlogin",curlogin);
                startActivity(i);

            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            Intent main3 = new Intent(MainActivity.this, MainActivity3.class);
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COlUMN_STATUS,"Unsign");
                sql3.update(TABLE_NAME1,contentValues,COLUMN_LOG + "=?",new String[]{curlogin});
                startActivity(main3);

            }
        });




        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment blankFragment = new BlankFragment();
                FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,blankFragment);
                ft.commit();

            }
        });
        buttongroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent group  = new Intent(MainActivity.this,MainActivity5.class);
                startActivity(group);
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
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabasel;
    String[] cn1 = null;
    private static final String DATABASE_NAME1 = "info2";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "Group";
    String selection1;
    public String log2;
    public String pas2;
    public String rol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("db");
        OpenHelper1 openHelperL = new OpenHelper1(MainActivity3.this);
        sqLiteDatabasel = openHelperL.getWritableDatabase();
        EditText edtl = (EditText) findViewById(R.id.login);
        EditText edtp = (EditText) findViewById(R.id.password);
        CheckBox check = (CheckBox) findViewById(R.id.checkbox);
        MaterialButton btns = (MaterialButton) findViewById(R.id.signbtn);
        MaterialButton btnr = (MaterialButton) findViewById(R.id.regbtn);
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = edtl.getText().toString();
                String pas = edtp.getText().toString();
                Log.d("mLog3","log = " + log +
                        ", password = " + pas);
                ContentValues contentValues = new ContentValues();
                switch (view.getId()) {
                    case R.id.regbtn:
                        contentValues.put(COLUMN_LOG,log);
                        contentValues.put(COLUMN_PAS,pas);
                        if(check.isChecked()){
                            contentValues.put(COLUMN_ROL,"Teacher");
                        }
                        else {
                            contentValues.put(COLUMN_ROL,"Pupil");
                        }
                        sqLiteDatabasel.insert(TABLE_NAME1, null, contentValues);
                        break;
                }
            }
        });
    btns.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent Main3 = new Intent(MainActivity3.this,MainActivity.class);
            Intent Main4 = new Intent(MainActivity3.this,MainActivity4.class);

            switch (view.getId()){
                case R.id.signbtn:
                    String log1 = edtl.getText().toString();
                    String pas1 = edtp.getText().toString();
                    cn1 = new String[]{log1};
                    selection1 = "Login = ?";
                    Cursor cursor1 = sqLiteDatabasel.query(TABLE_NAME1, null, selection1, cn1, null, null, null);
                    ContentValues contentValues1 = new ContentValues();
                    if (cursor1.moveToFirst()){
                        int login = cursor1.getColumnIndex(COLUMN_LOG);
                        int password  = cursor1.getColumnIndex(COLUMN_PAS);
                        int rol1 = cursor1.getColumnIndex(COLUMN_ROL);
                        log2 = cursor1.getString(login);
                        pas2 = cursor1.getString(password);
                        rol = cursor1.getString(rol1);
                        if(pas1.equals(pas2) & rol.equals("Teacher")){
                            Toast.makeText(MainActivity3.this,"УСПЕШНЫЙ ВХОД",Toast.LENGTH_SHORT).show();
                            startActivity(Main3);
                        }if(!(pas1.equals(pas2))) {
                            Toast.makeText(MainActivity3.this,"НЕПРАВИЛЬНЫЙ ПАРОЛЬ",Toast.LENGTH_SHORT).show();

                        }
                        if(pas1.equals(pas2) & rol.equals("Pupil")){
                            Toast.makeText(MainActivity3.this,"УСПЕШНЫЙ ВХОД",Toast.LENGTH_SHORT).show();
                            startActivity(Main4);}


                        do {
                            Log.d("mLog10","login = " + cursor1.getString(login)+
                                    ", password = " + cursor1.getString(password)+"roll="+(check.isChecked() | rol.equals("Teacher"))+(!(check.isChecked()) | rol.equals("Pupil")));
                        } while (cursor1.moveToNext());
                    }
                    else
                        Toast.makeText(MainActivity3.this,"ВЫ НЕ ЗАРЕСТИРОВАНЫ",Toast.LENGTH_SHORT).show();
                        Log.d("mLog","0 rows");
                    cursor1.close();
                    break;
            }

        }
    });


    }
    public static class OpenHelper1 extends SQLiteOpenHelper {

        OpenHelper1(Context context) {
            super(context, DATABASE_NAME1, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME1 + " (" +
                    COLUMN_ID + " integer primary key autoincrement, "
                    + COLUMN_LOG + " TEXT, "+COLUMN_ROL+" TEXT, " +COlUMN_GROUP+ "TEXT, "+ COLUMN_PAS + " TEXT );";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME1);
            onCreate(db);
        }
    }
}

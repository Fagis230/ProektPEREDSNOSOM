package com.example.proekt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class BlankFragment extends Fragment {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_blank, container, false);
        View v = inflater.inflate(R.layout.fragment_blank,null);
        dbHelper = new DBHelper(getActivity());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        button_edit = (Button) v.findViewById(R.id.editbtn);
        button_clear = (Button) v.findViewById(R.id.clear);

        edit = (EditText) v.findViewById(R.id.edittext);
        edit2 = (EditText) v.findViewById(R.id.editanswer);
        edit3 = (EditText) v.findViewById(R.id.edittem);


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


        return v;
    }
}
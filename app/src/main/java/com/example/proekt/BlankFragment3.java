package com.example.proekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;


public class BlankFragment3 extends Fragment {
    DBHelperlog dbHelperlog;
    SQLiteDatabase sqLiteDatabase;
    Button button8;
    EditText editText1;
    EditText editText2;

    private static final String DATABASE_NAME1 = "info4";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXT";
    private static final String COlUMN_TASK = "Task";
    private static final String COlUMN_STATUS = "Status";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_blank3, container, false);
        dbHelperlog  = new DBHelperlog(getActivity());
        sqLiteDatabase = dbHelperlog.getWritableDatabase();
        button8  =v.findViewById(R.id.button8);
        editText1 = v.findViewById(R.id.changel);
        editText2 = v.findViewById(R.id.changep);
        Bundle bundle =getArguments();


        String strtext = bundle.getString("message");
        Log.d("mLOOOO",strtext);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText1.getText().toString();
                String s1 = editText2.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_LOG,s);
                contentValues.put(COLUMN_PAS,s1);
                sqLiteDatabase.update(TABLE_NAME1,contentValues,COLUMN_LOG + "=?", new String[]{strtext});
            }
        });



        return v;
    }
}
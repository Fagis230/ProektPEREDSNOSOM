package com.example.proekt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragmenttaskgroup extends Fragment {
    Button button1;
    EditText task1;
    EditText group1;
    DBHelperlog dbHelper2;
    SQLiteDatabase sqLiteDatabase2;
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXT";
    private static final String COlUMN_TASK = "Task";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_fragmenttaskgroup, null);
        dbHelper2 = new DBHelperlog(getActivity());
        sqLiteDatabase2 = dbHelper2.getWritableDatabase();
        button1 = v.findViewById(R.id.buttontask);
        task1 = v.findViewById(R.id.task23);
        group1 = v.findViewById(R.id.group23);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                String st1 = group1.getText().toString();
                String ts1 = task1.getText().toString();
                contentValues.put(COlUMN_TASK,ts1);
                sqLiteDatabase2.update(TABLE_NAME1,contentValues,COlUMN_GROUP + "=?",new String[]{st1});


            }
        });

        return v;
    }
}


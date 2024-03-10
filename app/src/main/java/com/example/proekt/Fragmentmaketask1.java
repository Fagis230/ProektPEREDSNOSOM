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


public class Fragmentmaketask1 extends Fragment {    private static final String DATABASE_NAME1 = "info3";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXTTEXT";
    private static final String COlUMN_TASK = "Task";

    Button button;
    EditText task;
    EditText student;
    DBHelperlog dbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v =inflater.inflate(R.layout.fragment_fragmentmaketask1, null);
      button  = (Button) v.findViewById(R.id.button);
      task  = v.findViewById(R.id.task);
      dbHelper = new DBHelperlog(getActivity());
      sqLiteDatabase = dbHelper.getWritableDatabase();
      student = v.findViewById(R.id.student);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              ContentValues contentValues = new ContentValues();
              String st = student.getText().toString();
              String ts = task.getText().toString();
              contentValues.put(COlUMN_TASK,ts);
              sqLiteDatabase.update(TABLE_NAME1,contentValues,COLUMN_LOG + "=?",new String[]{st});


          }
      });

      return v;
    }
}
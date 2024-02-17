package com.example.proekt;

import android.content.ContentValues;
import android.content.Context;
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

import java.util.Arrays;

public class GroupFragment extends Fragment {
    private static final String DATABASE_NAME1 = "info2";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupText";
    private static final int DATABASE_VERSION  = 1;
    Button button5;
    EditText editText;
    EditText editText2;
    DBHelperlog db1;
    SQLiteDatabase sql1;
    String shegol;
    String selection1;
    String group;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_group, null);
        db1 = new DBHelperlog(getActivity());


        button5 = v.findViewById(R.id.button5);
        editText = v.findViewById(R.id.editshegol);
        editText2 = v.findViewById(R.id.groupedit);
        sql1 = db1.getWritableDatabase();
        button5.setOnClickListener(new View.OnClickListener() {
            ContentValues contentValues = new ContentValues();
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button5:
                        shegol = editText.getText().toString();
                        group = editText2.getText().toString();
                        contentValues.put(COlUMN_GROUP,group);
                        sql1.update(TABLE_NAME1,contentValues,COLUMN_LOG+"=?", new String[]{shegol});
                        Log.d("m", Arrays.toString(new String[]{shegol}));

                }



            }
        });

        return v;
    }
}
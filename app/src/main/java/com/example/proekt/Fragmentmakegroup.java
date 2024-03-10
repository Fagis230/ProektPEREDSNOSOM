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


public class Fragmentmakegroup extends Fragment {
    Button buttonmake;
    EditText editidpersons;
    EditText editidgroup;
    DBHelperlog dbHelperlog;
    SQLiteDatabase sqLite;
    private static final String DATABASE_NAME1 = "info4";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXTTEXT";
    private static final int DATABASE_VERSION  = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_fragmentmakegroup, null);
        dbHelperlog = new DBHelperlog(getActivity());
        buttonmake = v.findViewById(R.id.buttonmake);
        editidpersons = v.findViewById(R.id.idperson);
        editidgroup = v.findViewById(R.id.idgroup);
        sqLite = dbHelperlog.getWritableDatabase();
        buttonmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.buttonmake:
                        ContentValues contentValues =new ContentValues();
                        String idgroup = editidgroup.getText().toString();
                        String[] array = editidpersons.getText().toString().trim().split(",");
                        contentValues.put(COlUMN_GROUP,idgroup);
                        for(int i=0;i<array.length;i++){
                            String[] ar = new String[] {array[i].trim()};
                            sqLite.update(TABLE_NAME1,contentValues,COLUMN_LOG + "=?",ar);
                        }
                        Log.d("mmmm",Arrays.toString(array));



                }

            }
        });


        return v;
    }
}
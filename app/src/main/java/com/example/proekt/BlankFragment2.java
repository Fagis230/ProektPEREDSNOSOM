package com.example.proekt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment2 extends Fragment {
    DBHelperlog dbh;
    TextView textView;
    SQLiteDatabase sql;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank2, null);
        dbh = new DBHelperlog(getActivity());
        sql = dbh.getWritableDatabase();
        textView = v.findViewById(R.id.textView4);




        return v;
    }
}
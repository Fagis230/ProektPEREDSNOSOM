package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity5 extends AppCompatActivity {
    DBHelper dbHelper2;
    FrameLayout frameLayout1;
    Button buttongradd;
    Button makegroup;
    Button taskgroup;
    Button taskst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper2 = new DBHelper(this);
        setContentView(R.layout.activity_main5);
        frameLayout1 = findViewById(R.id.frameLayout1);
        buttongradd = (Button) findViewById(R.id.button3);
        taskgroup = (Button) findViewById(R.id.button6);
        taskst = (Button) findViewById(R.id.button5);
        makegroup = (Button) findViewById(R.id.button2);
        taskgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmenttaskgroup fragmenttaskgroup = new Fragmenttaskgroup();
                FragmentTransaction taskgr = getSupportFragmentManager().beginTransaction();
                taskgr.replace(R.id.frameLayout1,fragmenttaskgroup);
                taskgr.commit();
            }
        });
        taskst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmentmaketask1 fragmenttask = new Fragmentmaketask1();
                FragmentTransaction taskst = getSupportFragmentManager().beginTransaction();
                taskst.replace(R.id.frameLayout1,fragmenttask);
                taskst.commit();
            }
        });

        makegroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmentmakegroup fragmentmakegroup = new Fragmentmakegroup();
                FragmentTransaction frgr = getSupportFragmentManager().beginTransaction();
                frgr.replace(R.id.frameLayout1,fragmentmakegroup);
                frgr.commit();

            }
        });
        buttongradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupFragment fr1 = new GroupFragment();
                FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
                frag.replace(R.id.frameLayout1,fr1);
                frag.commit();
            }
        });


    }
}
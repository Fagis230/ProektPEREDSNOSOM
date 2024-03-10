package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {
    SQLiteDatabase sqLiteOpenHelper1;
    DBHelperlog dbHelperlog1;
    private static final String DATABASE_NAME1 = "info4";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXT";
    private static final String COlUMN_TASK = "Task";
    private static final String COlUMN_STATUS = "Status";
    TextView textView8;
    TextView textView9;
    TextView textView10;
    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        dbHelperlog1 = new DBHelperlog(this);
        sqLiteOpenHelper1 = dbHelperlog1.getWritableDatabase();
        Intent m = getIntent();
        textView8 = findViewById(R.id.textView11);
        textView9 = findViewById(R.id.textView12);
        textView10 = findViewById(R.id.textView13);
        String curlogin = m.getStringExtra("curlogin");
        button7 =findViewById(R.id.button10);
        Cursor cursor = sqLiteOpenHelper1.query(TABLE_NAME1,null,COLUMN_LOG +"=?",new String[]{curlogin},null,null,null);
        if(cursor.moveToFirst()){
            int l = cursor.getColumnIndex(COLUMN_LOG);
            int p = cursor.getColumnIndex(COLUMN_PAS);
            int r = cursor.getColumnIndex(COLUMN_ROL);
            String l1  =cursor.getString(l);
            String p1  =cursor.getString(p);
            String r1  =cursor.getString(r);
            textView8.setText(l1);
            textView9.setText(p1);
            textView10.setText(r1);

        }
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction ft1 =fragmentManager.beginTransaction();
                BlankFragment3 blankFragment3 =new BlankFragment3();
                Bundle bundle =new Bundle();
                bundle.putString("message",curlogin);
                blankFragment3.setArguments(bundle);
                ft1.replace(R.id.frameLayout233,blankFragment3);
                ft1.commit();
            }
        });

    }
}

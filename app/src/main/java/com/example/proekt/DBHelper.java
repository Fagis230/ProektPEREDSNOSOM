package com.example.proekt;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ZAD1.db";
    public static final String TABLE_NAME = "questions1";
    public static final String COLUMN_TEM = "TEM";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TEXTZ = "TEXTZ";
    public static final String COLUMN_ANSWER = "ANSWER";
    public static final String COLUMN_TASK = "Task";
    public static final int DATABASE_VERSION  = 1;
    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID  + " integer primary key autoincrement, "
                + COLUMN_TEXTZ +" TEXT, "+ COLUMN_ANSWER + " VARCHAR(50), "+COLUMN_TEM + " VARCHAR(1) );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

}

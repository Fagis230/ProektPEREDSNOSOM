package com.example.proekt;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DBHelperlog  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME1 = "info3";
    private static final String TABLE_NAME1 = "Persons";
    private static final String COLUMN_LOG = "Login";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PAS = "Password";
    private static final String COLUMN_ROL = "ROL";
    private static final String COlUMN_GROUP = "GroupTEXT";
    private static final String COlUMN_TASK = "Task";

    DBHelperlog(Context context) {
        super(context, DATABASE_NAME1, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME1 + " (" +
                COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_LOG + " TEXT, "+COlUMN_TASK +" VARCHAR(50), "+COLUMN_ROL+" TEXT, " +COlUMN_GROUP+ "TEXT, "+ COLUMN_PAS + " TEXT );";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME1);
        onCreate(db);
    }
}

package com.example.reminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String NAME = "reminder_List_Database";
    private static final String REMINDER_TABLE = "reminder";
    private static final String ID = "id";
    private static final String REMINDER_NAME = "name";
    private static final String DATE = "date";
    private static final String CREATE_REMINDER_TABLE = "CREATE TABLE " + REMINDER_TABLE + "(" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + REMINDER_NAME + " TEXT, " + DATE + " TEXT)";

    private SQLiteDatabase db;

    public Database(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REMINDER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REMINDER_TABLE);
        onCreate(db);
    }

    public void openDatabase() {
        db = this.getWritableDatabase();
    }

    public void deleteReminder(int id) {
        db.delete(REMINDER_TABLE, ID +"= ?", new String[] {String.valueOf(id)});
    }
}

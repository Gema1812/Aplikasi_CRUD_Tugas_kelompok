package com.example.tugaskelompokcrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDB";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Usertable(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, email TEXT, alamat TEXT, noHp TEXT)";
        Log.d("Data","onCreate: "+query);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int i, int i1) {

    }
}

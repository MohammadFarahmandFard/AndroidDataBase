package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "first.sqlite";
    public static final int DB_VERSION = 1;


    public MyDataBase(Context context) {

        super(context, CreateSQLiteDir.DB_DIR + '/' + DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE 'Persons' ( 'PersonID' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, 'Name' TEXT NOT NULL, 'Family' TEXT NOT NULL, 'Email' TEXT NOT NULL UNIQUE, 'Age' INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SyncStateContract.Constants.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}

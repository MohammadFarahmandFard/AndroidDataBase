package com.example.database;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;

public class CreateSQLiteDir extends Application {

    public static SQLiteDatabase database;

    public static CreateSQLiteDir cSQLDir;

    public static final String SDKARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String DETABASEFILE = SDKARD + "/dataBasefile";
    public static final String DB_DIR = DETABASEFILE + "/DB";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void creatSqliteDir(){
        File dbDir=new File(DB_DIR);
        if(!dbDir.exists()){
            dbDir.mkdirs();
            boolean wasCreate=dbDir.mkdirs();
            createDatabase();
        }else {
            createDatabase();
        }
    }

    public void createDatabase() {
        if(database != null){
            return;
        }
        MyDataBase MyDB=new MyDataBase(this);
        database=MyDB.getWritableDatabase();
    }
}

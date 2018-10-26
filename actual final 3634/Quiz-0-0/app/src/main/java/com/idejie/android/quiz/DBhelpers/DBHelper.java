package com.idejie.android.quiz.DBhelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//helper class to manage db
public class DBHelper  extends SQLiteOpenHelper {
    public static String CREATE_USERDATA = "create table lxrData(name varchar(200) primary key,number varchar(200),introduce varchar(200))";
    private Context mContext;
    public DBHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

package com.idejie.android.quiz.DBhelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class DBOperater {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBOperater(Context context) {
        dbHelper = new DBHelper(context, "Data", null, 1);
        db = dbHelper.getWritableDatabase();
    }

    // 添加
    public void add(Object obj) {
        db.execSQL("insert into lxrData values(?,?,?)",
                new Object[] { obj });

    }

    // 修改
    public void update(Object obj) {
        db.execSQL("update lxrData set number=?,introduce=? where name=?",
                new Object[] {obj });
    }

    // 删除联
    public void delete(String name) {
        db.execSQL("delete from lxrData where name=?", new String[] { name });
    }

    // 查询
    public Object queryOne(int id) {
       Object obj ;
        Cursor c = db.rawQuery("select * from Data where id= ?", new String[] { id+"" });
        while (c.moveToNext()) {
            obj=c;
        }
        c.close();
        return c;
    }

    public List<Object> queryAlllxr() {
        ArrayList<Object> datas = new ArrayList<Object>();
        Cursor c = db.rawQuery("select * from lData", null);
        while (c.moveToNext()) {
            datas.add(c);
        }
        c.close();
        return datas;

    }




}

package com.example.notes.Manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2020/6/20.
 */

public  class UserDbHelper extends SQLiteOpenHelper {
    static String name="user.db";
    static int dbVersion=1;
    public UserDbHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    //只在创建的时候用一次
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),sex varchar(2))";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
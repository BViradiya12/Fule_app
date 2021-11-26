package com.example.vehiclemaintanacesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String Database = "Admin";
    public static final String Table = "Fuel";
    public static final String Col_1 = "id";
    public static final String Col_2 = "vno";
    public static final String Col_3 = "date";
    public static final String Col_4 = "name";
    public static final String Col_5 = "rno";
    public static final String Col_6 = "km";
    public static final String Col_7 = "ltr";
    public static final String Col_8 = "price";

    public DatabaseHelper(@Nullable Context context)
    {
        super (context, Database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table if not exists "+Table+ "(id integer "+
                "primary key autoincrement, vno text, date integer, name text, rno integer, km integer, ltr integer, price integer)";
        Log.i("sql",sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){
        sqLiteDatabase.execSQL("drop table "+ Table);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String vno, String date, String name, String rno, String km, String ltr, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2,vno);
        values.put(Col_3,date);
        values.put(Col_4,name);
        values.put(Col_5,rno);
        values.put(Col_6,km);
        values.put(Col_7,ltr);
        values.put(Col_8,price);
        long result = db.insert(Table, null,values);
        return (result == -1)?false:true;
    }

    public Cursor selectData(){
        SQLiteDatabase db = getReadableDatabase();

        return db.query(Table,null,null,null,null,null,null);
    }

}

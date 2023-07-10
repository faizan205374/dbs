package com.example.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FAIZAN.db";
    private static final String TABLE_NAME = "LOCAL";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "HALL";
    private static final String COL_4 = "CITY";
    private static final String COL_5 = "C_ID";
    private static final String COL_6 = "DATE";
    private static final String COL_7 = "DISHES";
    private static final String COL_8 = "GUESTS";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, HALL TEXT, CITY TEXT, C_ID TEXT, DATE TEXT, DISHES TEXT, GUESTS TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertDonor(String name, String hall, String city,
                               String cid, String date, String dishes, String guests) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, hall);
        contentValues.put(COL_4, city);
        contentValues.put(COL_5, cid);
        contentValues.put(COL_6, date);
        contentValues.put(COL_7, dishes);
        contentValues.put(COL_8, guests);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
    public Cursor getAllDonors() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    public boolean updateDonor(String id, String name, String hall, String city,
                               String cid, String date, String dishes, String guests) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, hall);
        contentValues.put(COL_4, city);
        contentValues.put(COL_5, cid);
        contentValues.put(COL_6, date);
        contentValues.put(COL_7, dishes);
        contentValues.put(COL_8, guests);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Integer deleteDonor(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}

package com.example.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper1 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ADNAN.db";
    private static final String TABLE_NAME = "SPECIAL";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "MAIL";
    private static final String COL_4 = "PHONE";
    private static final String COL_5 = "CITY";
    private static final String COL_6 = "ADDRESS";
    private static final String COL_7 = "PAID";
    private static final String COL_8 = "PAID_TO";
    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, MAIL TEXT, PHONE TEXT, CITY TEXT, ADDRESS TEXT, PAID TEXT, PAID_TO TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertDonor1(String name, String mail, String phone,
                               String city, String address, String payment, String to) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, mail);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, city);
        contentValues.put(COL_6, address);
        contentValues.put(COL_7, payment);
        contentValues.put(COL_8, to);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
    public Cursor getAllDonors1() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    public boolean updateDonor1(String id, String name, String mail, String phone,
                                String city, String address, String payment, String to) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, mail);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, city);
        contentValues.put(COL_6, address);
        contentValues.put(COL_7, payment);
        contentValues.put(COL_8, to);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }
    public Cursor getAllData1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Integer deleteDonor1(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}

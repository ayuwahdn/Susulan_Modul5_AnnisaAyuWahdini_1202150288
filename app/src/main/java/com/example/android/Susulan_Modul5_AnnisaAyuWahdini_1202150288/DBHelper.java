package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends  SQLiteOpenHelper{
    //inisiasi komponen yang akan digunakan pada SQLite
    private static final String Table = "todolist";
    private static final String kolom1 = "id";
    private static final String kolom2 = "nama";
    private static final String kolom3 = "deskripsi";
    private static final String kolom4 = "prioritas";

    public DBHelper(Context context) {

        super(context, Table, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSql = "CREATE TABLE " + Table + "(" + kolom1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                kolom2 + " TEXT," +
                kolom3 + " TEXT," +
                kolom4 + " TEXT)";
        db.execSQL(createSql);
    }

    //onUpgrade is only called when the database file exists but the stored version number is lower than requested in constructor.
    // The onUpgrade() should update the table schema to the requested version.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        onCreate(db);

    }
    public boolean addData(String nama, String deskripsi, String prioritas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues in = new ContentValues();
        in.put(kolom2, nama);
        in.put(kolom3, deskripsi);
        in.put(kolom4, prioritas);
        long result = db.insert(Table, null, in);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //mengambil data dari tabel dalam db
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + Table;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //menghapus data dari tabel db
    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "DELETE FROM " + Table + " WHERE " + kolom1 + " = '" + id + "'";
        db.execSQL(q);

    }
}

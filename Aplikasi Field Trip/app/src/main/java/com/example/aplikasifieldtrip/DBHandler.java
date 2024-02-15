package com.example.aplikasifieldtrip;

// import database SQLLite
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    // deklarasi setiap variabel dalam Database yang bersifat Final
    private static final String DB_NAME = "db_fieldtrip";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tabelMahasiswa";
    private static final String ID_COL = "id";
    private static final String NAMA_COL = "nama_mhs";
    private static final String NIM_COL = "nim";
    private static final String NO_HP_COL = "no_hP";
    private static final String NO_MAKAN_COL = "no_makan";

    // membuat sebuah constructor untuk DBHandler
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // membuat sebuah method untuk membuat sebuah database berdasarkan query yang dikirimkan
    @Override
    public void onCreate(SQLiteDatabase db) {
        // membuat query yang berisikan nama tabel, id, nama_mhs, nim, no_hp, no_makan
        // yang nantinya akan menjadi struktur dari tabelMahasiswa
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAMA_COL + " TEXT, "
                + NIM_COL + " TEXT, "
                + NO_HP_COL + " TEXT, "
                + NO_MAKAN_COL + " TEXT)";

        // melakukan eksekusi dari Query di atas
        db.execSQL(query);
    }

    // membuat sebuah method untuk menambahkan mahasiswa ke tabelMahasiswa
    public void tambahMahasiswa(String namaMahasiswa, String NIM, String noHandphone, String noMakan) {
        SQLiteDatabase db = this.getWritableDatabase();
        // menginisiasi sebuah ContentValues yang akan menyimpan setiap nilai String dari detailMhs
        ContentValues values = new ContentValues();

        // menambahkan setiap values berdasarkan dari parameter yang ada dalam method
        // tambahMahasiswa
        values.put(NAMA_COL, namaMahasiswa);
        values.put(NIM_COL, NIM);
        values.put(NO_HP_COL, noHandphone);
        values.put(NO_MAKAN_COL, noMakan);

        // menjalankan/memasukan values di atas ke dalam database
        db.insert(TABLE_NAME, null, values);

        // ketika sudah selesai digunakan, tutup database
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

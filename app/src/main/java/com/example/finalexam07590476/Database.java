package com.example.finalexam07590476;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "User";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "user";
    public static final String username = "username";
    public static final String password = "password";
    public static final String fullname = "fullname";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + username + " VARCHAR, " + password + " VARCHAR, "
                + fullname + " VARCHAR);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // Insert Data
    public long InsertData(String username, String password, String fullname) {

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data


            ContentValues Val = new ContentValues();
            Val.put("username", username);
            Val.put("fullname", fullname);
            Val.put("password", password);

            long rows = db.insert(TABLE_NAME, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

}

    public class Database {

}

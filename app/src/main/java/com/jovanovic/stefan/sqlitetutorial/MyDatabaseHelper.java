package com.jovanovic.stefan.sqlitetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "AddLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_adding_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DOCTOR = "adding_doctor";
    private static final String COLUMN_SPECIALIZATION = "adding_specialization";
    private static final String COLUMN_PATIENT = "adding_patient";
    private static final String COLUMN_PID = "adding_pid";
    private static final String COLUMN_EMAIL = "adding_email";
    private static final String COLUMN_CHANNEL = "adding_channel";
    private static final String COLUMN_DISEASE = "adding_disease";


    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_DOCTOR + " TEXT, " +
                        COLUMN_SPECIALIZATION + " TEXT, " +
                        COLUMN_PATIENT + " TEXT, " +
                        COLUMN_PID + " TEXT, " +
                        COLUMN_EMAIL + " TEXT, " +
                        COLUMN_CHANNEL + " TEXT, " +
                        COLUMN_DISEASE + " TEXT);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBook(String title, String author, int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DOCTOR, doctor);
        cv.put(COLUMN_SPECIALIZATION, specialization);
        cv.put(COLUMN_PATIENT, patient);
        cv.put(COLUMN_PID, pid);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_CHANNEL, channel);
        cv.put(COLUMN_DISEASE, disease);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String doctor, String specialization, String patient, String pid, String email, String channel, String disease){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DOCTOR, doctor);
        cv.put(COLUMN_SPECIALIZATION, specialization);
        cv.put(COLUMN_PATIENT, patient);
        cv.put(COLUMN_PID, pid);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_CHANNEL, channel);
        cv.put(COLUMN_DISEASE, disease);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}

package com.example.moumoutsay.jsphdev_a3_a.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Author: Wei-Lin Tsai weilints@andrew.cmu.edu
 * Date: on 4/7/15.
 * TODO drop data when onDestroy
 */

public class DBUtil extends SQLiteOpenHelper {
    public static final int data_base_version = 1;

    public DBUtil(Context context) {
        super(context, SQLCmd.DATEBASE_NAME, null, data_base_version);
        Log.d("DBUtil", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCmd.CREATE_TB_STUDENT);
        db.execSQL(SQLCmd.CREATE_TB_EXAM_RECORD);
        Log.d("DBUtil", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void dropTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + SQLCmd.TB_EXAM_RECORD);
        db.execSQL("DROP TABLE IF EXISTS " + SQLCmd.TB_STUDENT);
    }

    public void addStudentInfo(DBUtil dbUtil, int sid) {
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        ContentValues cv = new ContentValues();

        onCreate(db);

        cv.put(SQLCmd.STUDENT_ID, sid);

        db.insertWithOnConflict(SQLCmd.TB_STUDENT, null, cv, SQLiteDatabase.CONFLICT_IGNORE) ;

        Log.d("DBUtil", "addStudentInfo done");
    }

    public void addExamRecord(DBUtil dbUtil, int sid, int[] scores) {
        if (scores.length != 5) { return; }

        SQLiteDatabase db = dbUtil.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLCmd.FOREIGN_SID, sid);
        cv.put(SQLCmd.Q1, scores[0]);
        cv.put(SQLCmd.Q2, scores[1]);
        cv.put(SQLCmd.Q3, scores[2]);
        cv.put(SQLCmd.Q4, scores[3]);
        cv.put(SQLCmd.Q5, scores[4]);

        db.insert(SQLCmd.TB_EXAM_RECORD, null, cv) ;
        Log.d("DBUtil", "addExamRecord done");
    }


    public String getAllStudentInfo(DBUtil dbUtil) {
        StringBuilder sb = new StringBuilder();
        SQLiteDatabase db = dbUtil.getReadableDatabase();
        String[] columns = {SQLCmd.STUDENT_ID};

        Cursor cr = db.query(SQLCmd.TB_STUDENT, columns,
                null,
                null,
                null, null, null, null);

        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            sb.append ("SID: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.STUDENT_ID)) + "\n");
            cr.moveToNext();
        }
        // make sure to close the cursor
        cr.close();

        return sb.toString();
    }

    public String getAllScores(DBUtil dbUtil) {
        StringBuilder sb = new StringBuilder();
        SQLiteDatabase db = dbUtil.getReadableDatabase();
        String[] columns = {SQLCmd.FOREIGN_SID, SQLCmd.Q1, SQLCmd.Q2, SQLCmd.Q3, SQLCmd.Q4, SQLCmd.Q5};

        Cursor cr = db.query(SQLCmd.TB_EXAM_RECORD, columns,
                null,
                null,
                null, null, null, null);

        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            sb.append("SID: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.FOREIGN_SID)) + " ");
            sb.append("Q1: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.Q1)) + "  ");
            sb.append("Q2: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.Q2)) + "  ");
            sb.append("Q3: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.Q3)) + "  ");
            sb.append("Q4: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.Q4)) + "  ");
            sb.append("Q5: " + cr.getString(cr.getColumnIndexOrThrow(SQLCmd.Q5)) + "  ");
            sb.append("\n");
            cr.moveToNext();
        }
        // make sure to close the cursor
        cr.close();

        return sb.toString();
    }
}

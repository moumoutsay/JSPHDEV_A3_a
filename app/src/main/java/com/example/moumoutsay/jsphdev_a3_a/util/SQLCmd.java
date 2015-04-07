package com.example.moumoutsay.jsphdev_a3_a.util;

/**
 * Author: Wei-Lin Tsai weilints@andrew.cmu.edu
 * Date: on 4/7/15.
 *
 * Put all SQL command here. Will refactor in the future
 */

public class SQLCmd {

    public static final String USER_NAME = "user_name";
    public static final String USER_PASS = "user_pass";
    public static final String DATEBASE_NAME = "exam_recorder";

    public static final String TB_STUDENT = "tb_student";
    public static final String TB_EXAM_RECORD = "tb_exam_record";

    public static final String STUDENT_ID = "student_id";

    public static final String Q1 = "q1";
    public static final String Q2 = "q2";
    public static final String Q3 = "q3";
    public static final String Q4 = "q4";
    public static final String Q5 = "q5";
    public static final String FOREIGN_SID = "fsid";

    public static final String CREATE_TB_STUDENT = "create table IF NOT EXISTS "
            + TB_STUDENT + " ( " + STUDENT_ID + " INTEGER PRIMARY KEY "
            + " )";

    public static final String CREATE_TB_EXAM_RECORD = "create table IF NOT EXISTS "
            + TB_EXAM_RECORD + " ( id INTEGER PRIMARY KEY ASC, "
            + Q1 + " INTEGER, "
            + Q2 + " INTEGER, "
            + Q3 + " INTEGER, "
            + Q4 + " INTEGER, "
            + Q5 + " INTEGER, "
            + FOREIGN_SID + " INTEGER, "
            + "FOREIGN KEY(" + FOREIGN_SID + ") REFERENCES " + TB_STUDENT + "(" + STUDENT_ID + ")  ON DELETE CASCADE ON UPDATE CASCADE "
            + " )";
}

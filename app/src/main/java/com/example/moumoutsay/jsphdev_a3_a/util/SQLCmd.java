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

    public static final String AMOUNT = "amount";
    public static final String YEARS = "years";
    public static final String RATE = "rate";
    public static final String PROPERTY_TAX = "property_tax";
    public static final String PROPERTY_INSURANCE = "property_insurance";
    public static final String MONTHLY_PAYMENT = "monthly_payment";
    public static final String TOTAL_PAYMENT = "total_payment";

    public static final String CREATE_TB_STUDENT = "create table IF NOT EXISTS "
            + TB_STUDENT + " ( " + STUDENT_ID + " INTEGER PRIMARY KEY "
            + " )";


//    public static final String CREATE_PAYOFF_DATE = "create table IF NOT EXISTS "
//            + TB_PAYOFF_DATE + " ( id INTEGER PRIMARY KEY ASC,"
//            + " begin_mon int,"
//            + " begin_year int,"
//            + " total_year int,"
//            + " payoff_date VARCHAR(30)"
//            + " )";
//
//    //   public String getTotalPayment(double amount, int years, double rate, int propertyTax, int propertyInsurance)
//    public static final String CREATE_PAYMENT = "create table IF NOT EXISTS "
//            + TB_PAYMENT + " ( id INTEGER PRIMARY KEY ASC, "
//            + AMOUNT + " REAL, "
//            + YEARS + " INTEGER, "
//            + RATE + " REAL, "
//            + PROPERTY_TAX + " INTEGER, "
//            + PROPERTY_INSURANCE + " INTEGER, "
//            + MONTHLY_PAYMENT + " VARCHAR(30), "
//            + TOTAL_PAYMENT + " VARCHAR(30) "
//            + " )";
}

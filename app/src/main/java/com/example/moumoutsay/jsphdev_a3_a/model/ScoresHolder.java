package com.example.moumoutsay.jsphdev_a3_a.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moumoutsay on 4/6/15.
 */
public class ScoresHolder {
    final int QUIZ_NUM = 5;
    private List<Student> studentList;

    public ScoresHolder() {
        studentList = new ArrayList<Student> ();
    }

    // if exceed 40, do nothing
    public void addStudent(Student student) {
        if (student != null) {
            int newID = student.getSID();
            boolean isNew = true;
//          No override now
//            for (int i = 0; i < studentList.size(); i++) {
//                if (studentList.get(i).getSID() == newID) {
//                    isNew = false;
//                }
//            }
            if (isNew && (studentList.size() < 40)) {
                studentList.add(student);
            }
        }
    }

    public List<String> getAllScores() {
        List<String> res = new ArrayList<String>();
        res.add("STUD      Q1    Q2    Q3    Q4     Q5");

        for (int i = 0; i < studentList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Student aStudent = studentList.get(i);
            sb.append(aStudent.getSID() + "      ");
            int[] sc = aStudent.getScores();
            for (int j = 0; j < sc.length; j++) {
                sb.append(sc[j] + "    ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public int[] getLow() {
        int [] lowScores = new int [QUIZ_NUM];
        for (int i = 0; i < lowScores.length; i++) {
            lowScores[i] = 100;
        }
        // go
        for (int i = 0; i < studentList.size(); ++i) {
            int scoreOfAStudent[] = studentList.get(i).getScores();
            for (int j = 0; j < QUIZ_NUM; ++j) {
                int aScore = scoreOfAStudent[j];
                if (aScore > 100 || aScore < 0) { continue; } // do basic error handling here
                if (aScore < lowScores[j]) {
                    lowScores[j] = aScore;
                }
            }
        }
        return lowScores;
    }

    public int[] getHigh() {
        int [] highScores = new int [QUIZ_NUM];
        for (int i = 0; i < highScores.length; i++) {
            highScores[i] = 0;
        }
        // go
        for (int i = 0; i < studentList.size(); ++i) {
            int scoreOfAStudent[] = studentList.get(i).getScores();
            for (int j = 0; j < QUIZ_NUM; ++j) {
                int aScore = scoreOfAStudent[j];
                if (aScore > 100 || aScore < 0) { continue; } // do basic error handling here
                if (aScore > highScores[j]) {
                    highScores[j] = aScore;
                }
            }
        }
        return highScores;
    }

    public double[] getAvg() {
        double [] avgScores = new double[QUIZ_NUM];
        for (int i = 0; i < avgScores.length; i++) {
            avgScores[i] = 0;
        }
        if ( studentList.size() == 0) {
            return avgScores;
        }
        for (int i = 0; i < studentList.size(); ++i) {
            int scoreOfAStudent[] = studentList.get(i).getScores();
            for (int j = 0; j < QUIZ_NUM; ++j) {
                int aScore = scoreOfAStudent[j];
                if (aScore > 100 || aScore < 0) { continue; } // do basic error handling here
                avgScores[j] += aScore;
            }
        }
        for (int i = 0; i < QUIZ_NUM; ++i) {
            avgScores[i] = avgScores[i] / studentList.size();
        }

        return avgScores;
    }
}

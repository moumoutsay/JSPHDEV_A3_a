package com.example.moumoutsay.jsphdev_a3_a.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moumoutsay.jsphdev_a3_a.R;
import com.example.moumoutsay.jsphdev_a3_a.model.ScoresHolder;
import com.example.moumoutsay.jsphdev_a3_a.model.Student;
import com.example.moumoutsay.jsphdev_a3_a.util.DBUtil;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    final static int QUIZ_NUM = 5;
    final static String LOG_TAG = MainFragment.class.getSimpleName();

    private ScoresHolder scoresHolder;

    public MainFragment() {
        scoresHolder = new ScoresHolder();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = (Button) getActivity().findViewById(R.id.button_add_score);
        button.setOnClickListener(this);
    }

//    @Override
//    public void onStop() {
//        DBUtil dbUtil = new DBUtil(getActivity());
//        dbUtil.dropTables();
//        Log.d(LOG_TAG, "Drop table is onStop()");
//
//        super.onStop();
//    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add_score:
                Log.d(LOG_TAG, "click the button");
                Student st = updateListScores();
                if (st == null) { break; }
                updateDB(st);
                updateStatResult();
                resetInputValues();
            break;
        }
    }

    /* Input Data part */
    private void resetInputValues() {
        View view = getView();

        EditText editID = (EditText) view.findViewById(R.id.edit_id);
        EditText editQ1 = (EditText) view.findViewById(R.id.edit_q1);
        EditText editQ2 = (EditText) view.findViewById(R.id.edit_q2);
        EditText editQ3 = (EditText) view.findViewById(R.id.edit_q3);
        EditText editQ4 = (EditText) view.findViewById(R.id.edit_q4);
        EditText editQ5 = (EditText) view.findViewById(R.id.edit_q5);

        editID.setText("");
        editQ1.setText("");
        editQ2.setText("");
        editQ3.setText("");
        editQ4.setText("");
        editQ5.setText("");
    }

    /* Update list score part */
    private Student updateListScores() {
        Log.d(LOG_TAG, "Enter updateListScores()");

        // update data
        Student st = retrieveAScore();
        scoresHolder.addStudent(st);

        // refresh listView
        List<String> scoresList = scoresHolder.getAllScores();
        ArrayAdapter<String> scoresAdapter = new ArrayAdapter<String> (getActivity(), R.layout.fragment_list_one_score, R.id.list_added_data_textview, scoresList);
        ListView lv = (ListView) getActivity().findViewById(R.id.listviewAllScores);
        lv.setAdapter(scoresAdapter);
        return st;
    }

    private Student retrieveAScore() {
        Student st = new Student();
        try  {
            View view = getView();

            EditText editID = (EditText) view.findViewById(R.id.edit_id);
            EditText editQ1 = (EditText) view.findViewById(R.id.edit_q1);
            EditText editQ2 = (EditText) view.findViewById(R.id.edit_q2);
            EditText editQ3 = (EditText) view.findViewById(R.id.edit_q3);
            EditText editQ4 = (EditText) view.findViewById(R.id.edit_q4);
            EditText editQ5 = (EditText) view.findViewById(R.id.edit_q5);

            st.setSID(Integer.parseInt(editID.getText().toString()));
            int[] scores = new int[QUIZ_NUM];

            scores[0] = Integer.parseInt(editQ1.getText().toString());
            scores[1] = Integer.parseInt(editQ2.getText().toString());
            scores[2] = Integer.parseInt(editQ3.getText().toString());
            scores[3] = Integer.parseInt(editQ4.getText().toString());
            scores[4] = Integer.parseInt(editQ5.getText().toString());
            st.setScores(scores);

            if (st.getSID() > 9999 || st.getSID() < 1000) {
                throw new Exception("InValid id");
            }
            for (int i = 0; i < QUIZ_NUM; i++) {
                if (scores[i] > 100) {
                    throw new Exception("InValid score: Quiz " + i+1);
                }
            }

            return st;
        } catch (Exception e) {
            Log.i(LOG_TAG, "The input is invalid" + e.toString());
        }
        return null;
    }

    /* Stat result part */
    private void updateStatResult() {
        Log.d(LOG_TAG, "Enter updateStatResult()");
        // Update low score
        int[] lowScores = scoresHolder.getLow();
        int[] highScores = scoresHolder.getHigh();
        double[] avgScores = scoresHolder.getAvg();

        TextView h1 = (TextView) getActivity().findViewById(R.id.text_high_q1);
        TextView h2 = (TextView) getActivity().findViewById(R.id.text_high_q2);
        TextView h3 = (TextView) getActivity().findViewById(R.id.text_high_q3);
        TextView h4 = (TextView) getActivity().findViewById(R.id.text_high_q4);
        TextView h5 = (TextView) getActivity().findViewById(R.id.text_high_q5);

        h1.setText(Integer.toString(highScores[0]));
        h2.setText(Integer.toString(highScores[1]));
        h3.setText(Integer.toString(highScores[2]));
        h4.setText(Integer.toString(highScores[3]));
        h5.setText(Integer.toString(highScores[4]));

        TextView l1 = (TextView) getActivity().findViewById(R.id.text_low_q1);
        TextView l2 = (TextView) getActivity().findViewById(R.id.text_low_q2);
        TextView l3 = (TextView) getActivity().findViewById(R.id.text_low_q3);
        TextView l4 = (TextView) getActivity().findViewById(R.id.text_low_q4);
        TextView l5 = (TextView) getActivity().findViewById(R.id.text_low_q5);

        l1.setText(Integer.toString(lowScores[0]));
        l2.setText(Integer.toString(lowScores[1]));
        l3.setText(Integer.toString(lowScores[2]));
        l4.setText(Integer.toString(lowScores[3]));
        l5.setText(Integer.toString(lowScores[4]));

        TextView a1 = (TextView) getActivity().findViewById(R.id.text_avg_q1);
        TextView a2 = (TextView) getActivity().findViewById(R.id.text_avg_q2);
        TextView a3 = (TextView) getActivity().findViewById(R.id.text_avg_q3);
        TextView a4 = (TextView) getActivity().findViewById(R.id.text_avg_q4);
        TextView a5 = (TextView) getActivity().findViewById(R.id.text_avg_q5);

        a1.setText(String.format("%.1f", avgScores[0]));
        a2.setText(String.format("%.1f", avgScores[1]));
        a3.setText(String.format("%.1f", avgScores[2]));
        a4.setText(String.format("%.1f", avgScores[3]));
        a5.setText(String.format("%.1f", avgScores[4]));
    }

    private void updateDB(Student st) {
        if (st == null) { return; } // basic error handeling
        DBUtil dbUtil = new DBUtil(getActivity());
        dbUtil.addStudentInfo(dbUtil, st.getSID());
        Log.d(LOG_TAG, "After update, all the student is:\n" + dbUtil.getAllStudentInfo(dbUtil) );
        dbUtil.addExamRecord(dbUtil, st.getSID(), st.getScores());
        Log.d(LOG_TAG, "After update, all the scores is:\n" + dbUtil.getAllScores(dbUtil) );
    }
}

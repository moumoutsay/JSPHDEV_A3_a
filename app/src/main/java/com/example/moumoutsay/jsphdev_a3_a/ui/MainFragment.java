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

import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    final static String LOG_TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add_score:
                Log.d(LOG_TAG, "click the button");
                resetInputValues();
                updateListScores();
                updateStatResult();
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
    private void updateListScores() {
        Log.d(LOG_TAG, "Enter updateListScores()");
        // TODO update data
        // TODO refresh listView

        // use fake data for now
                /* For the list view part */
        String[] mockData = {
                "STUD      Q1    Q2    Q3    Q4     Q5",
                "1234      11    21    31    41     51"
        };
        List<String> scoresList = Arrays.asList(mockData);
        ArrayAdapter<String> scoresAdapter = new ArrayAdapter<String> (getActivity(), R.layout.fragment_list_one_score, R.id.list_added_data_textview, scoresList);
        ListView lv = (ListView) getActivity().findViewById(R.id.listviewAllScores);
        lv.setAdapter(scoresAdapter);

    }

    /* Stat result part */
    private void updateStatResult() {
        Log.d(LOG_TAG, "Enter updateStatResult()");
        // TODO update result
        // TODO refresh display result

        TextView t = (TextView) getActivity().findViewById(R.id.text_high_q5);
        t.setText("AsSSSS");
    }


}

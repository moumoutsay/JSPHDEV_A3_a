package com.example.moumoutsay.jsphdev_a3_a.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.moumoutsay.jsphdev_a3_a.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by moumoutsay on 4/6/15.
 */
public class ListScoresFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_all_scores, container, false);
                /* For the list view part */
        String[] mockData = {
                "STUD      Q1    Q2    Q3    Q4     Q5",
                "1234      10    20    30    40     50"
        };
        List<String> scoresList = Arrays.asList(mockData);
        ArrayAdapter<String> scoresAdapter = new ArrayAdapter<String> (getActivity(), R.layout.fragment_list_one_score, R.id.list_added_data_textview, scoresList);
        ListView lv = (ListView) rootView.findViewById(R.id.listviewAllScores);
        lv.setAdapter(scoresAdapter);

        return rootView;
    }
}

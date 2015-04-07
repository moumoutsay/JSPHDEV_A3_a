package com.example.moumoutsay.jsphdev_a3_a.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.moumoutsay.jsphdev_a3_a.R;
import com.example.moumoutsay.jsphdev_a3_a.util.DecimalDigitsInputFilter;

/**
 * Created by moumoutsay on 4/6/15.
 */
public class InputDataFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_input_data, container, false);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        limitDigitsOfEditText(getActivity());
    }

    private void limitDigitsOfEditText(Activity act) {
        EditText editID = (EditText) act.findViewById(R.id.edit_id);
        EditText editQ1 = (EditText) act.findViewById(R.id.edit_q1);
        EditText editQ2 = (EditText) act.findViewById(R.id.edit_q2);
        EditText editQ3 = (EditText) act.findViewById(R.id.edit_q3);
        EditText editQ4 = (EditText) act.findViewById(R.id.edit_q4);
        EditText editQ5 = (EditText) act.findViewById(R.id.edit_q5);

        // limit digits
        editID.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(4,1)});
        editQ1.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        editQ2.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        editQ3.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        editQ4.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        editQ5.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
    }
}

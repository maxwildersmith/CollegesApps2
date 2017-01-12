package com.example.csaper6.collegesapps2.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.csaper6.collegesapps2.Model.Guardian;
import com.example.csaper6.collegesapps2.R;

/**
 * Created by csaper6 on 12/9/16.
 */
public class GuardianFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_family, container, false);
        EditText fName = (EditText) (rootView.findViewById(R.id.first_name));
        EditText lName = (EditText) (rootView.findViewById(R.id.last_name));
        EditText occupation = (EditText) (rootView.findViewById(R.id.job));
        NumberPicker age = (NumberPicker)(rootView.findViewById(R.id.age));
        age.setMinValue(18);
        age.setMaxValue(333);

        Guardian g = new Guardian(fName.getText().toString(),lName.getText().toString(),occupation.getText().toString(),age.getValue());

        return rootView;
    }
}

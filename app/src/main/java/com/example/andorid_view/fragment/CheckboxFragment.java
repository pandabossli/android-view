package com.example.andorid_view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.andorid_view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CheckboxFragment extends Fragment {
    TextView checkbox_text;
    CheckBox checkbox1,checkbox2,checkbox3;
    private String res = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkbox, container, false);
        checkbox_text = view.findViewById(R.id.checkbox_text);
        checkbox1 = view.findViewById(R.id.checkbox1);
        checkbox2 = view.findViewById(R.id.checkbox2);
        checkbox3 = view.findViewById(R.id.checkbox3);

        checkbox1.setOnCheckedChangeListener(mycheckbox);
        checkbox2.setOnCheckedChangeListener(mycheckbox);
        checkbox3.setOnCheckedChangeListener(mycheckbox);
        return view;
    }

    private CheckBox.OnCheckedChangeListener mycheckbox = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            List<String> result = new ArrayList<String>();
            res = "";
            if(checkbox1.isChecked()) {
                result.add(checkbox1.getText().toString());
            }
            if(checkbox2.isChecked()) {
                result.add(checkbox2.getText().toString());
            }
            if(checkbox3.isChecked()) {
                result.add(checkbox3.getText().toString());
            }

            for(int i = 0;i<result.size();i++) {
                res += result.get(i)+",";
            }
            checkbox_text.setText(res == ""?"": res.substring(0, res.length()-1));
        }
    };
}
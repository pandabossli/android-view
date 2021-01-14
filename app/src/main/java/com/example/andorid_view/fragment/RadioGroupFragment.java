package com.example.andorid_view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andorid_view.R;

public class RadioGroupFragment extends Fragment {
    private TextView radio_sex_text;
    private RadioGroup radio_sex_group;
    private RadioButton radio_sex_1,radio_sex_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio,container,false);
        radio_sex_text = view.findViewById(R.id.radio_sex_text);
        radio_sex_group = view.findViewById(R.id.radio_sex_group);

        radio_sex_1 = view.findViewById(R.id.radio_sex_1);
        radio_sex_2 = view.findViewById(R.id.radio_sex_2);
        radio_sex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio_sex_1){
                    radio_sex_text.setText(radio_sex_1.getText());
                }else {
                    radio_sex_text.setText(radio_sex_2.getText());
                }
            }
        });
        return view;
    }
}

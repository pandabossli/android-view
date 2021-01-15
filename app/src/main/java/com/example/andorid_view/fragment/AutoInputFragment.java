package com.example.andorid_view.fragment;
/**
 * 自动提示输入框
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.andorid_view.R;

public class AutoInputFragment extends Fragment {
    private String[] normalString = new String[] {"Android","Android Blog","Android M"};
    private TextView autoinput_textview;
    private Button autoinput_clear;
    private AutoCompleteTextView autoinput_autotextview;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_autoinput, container, false);
        autoinput_textview = view.findViewById(R.id.autoinput_textview);
        autoinput_clear = view.findViewById(R.id.autoinput_clear);
        autoinput_autotextview = view.findViewById(R.id.autoinput_autotextview);
        // 实现一个适配器对象，用来给自动完成输入狂添加自动装入的内容
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,normalString);
        autoinput_autotextview.setAdapter(arrayAdapter);
        autoinput_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoinput_textview.setText(autoinput_autotextview.getText());
            }
        });
        return view;
    }
    // todo: 当点击提示项时，自动选择被点击的内容
}

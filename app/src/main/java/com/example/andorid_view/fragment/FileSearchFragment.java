package com.example.andorid_view.fragment;
/**
 * 文件搜索
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andorid_view.R;

import java.io.File;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FileSearchFragment extends Fragment {
    private EditText search_edit;
    private Button search_btn;
    private TextView search_result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_search, container, false);
        search_edit = view.findViewById(R.id.search_edit);
        search_btn = view.findViewById(R.id.search_btn);
        search_result = view.findViewById(R.id.search_result);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchStr = search_edit.getText().toString();
                if(searchStr.equals("")) {
                    search_result.setText("不能为空");
                }else {
                    search_result.setText(searchFile(searchStr));
                }
            }

            private String searchFile(String searchStr) {
                String result = "";
                File[] file = new File("/").listFiles();
                Log.i("TAG", "searchFile: "+ Arrays.toString(file));
                if(file.length > 0 ) {
                    for(File f:file){
                        if(f.getName().indexOf(searchStr) >= 0) {
                            result+=f.getPath()+"\n";
                        }
                    }
                }

                if(result.equals("")) return "大佬，找不到你要的文件";
                return result;
            }
        });
        return view;
    }
}
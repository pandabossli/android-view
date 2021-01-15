package com.example.andorid_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends AppCompatActivity {
    private ArrayList<HashMap<String,Object>> users = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        for(int i = 0; i < 100; i++) {
            HashMap<String,Object> user = new HashMap<String,Object>();
            user.put("img",R.drawable.ic_launcher_foreground);
            user.put("name","姓名"+i);
            user.put("age",20+i);
            users.add(user);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, users,R.layout.activity_simple_adapter_user,new String[]{"img","name","age"},new int[]{R.id.img,R.id.name,R.id.age});
        ListView listView = findViewById(R.id.simple_adapter);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> user1 = new HashMap<String,Object>();
                user1 = users.get(position);
                String name = user1.get("name").toString();
                Toast.makeText(SimpleAdapterActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,SimpleAdapterActivity.class));
    }

}
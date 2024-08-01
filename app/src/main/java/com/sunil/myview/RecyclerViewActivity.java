package com.sunil.myview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunil.myview.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<String> dataList = getIntent().getStringArrayListExtra("dataList");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        com.sunil.myview.RecyclerViewAdapter adapter = new com.sunil.myview.RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}
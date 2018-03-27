package com.example.sachin.learnwithme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sachin.learnwithme.data.CategoryData;
import com.example.sachin.learnwithme.data.DataService;

import java.util.List;

public class CatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cat);


        List<CategoryData> catData= DataService.getData();


        RecyclerView myrw = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, catData );
        myrw.setLayoutManager(new GridLayoutManager(this, 3));
        myrw.setAdapter(myAdapter);
    }

}

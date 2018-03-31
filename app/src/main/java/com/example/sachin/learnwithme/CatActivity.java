package com.example.sachin.learnwithme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sachin.learnwithme.data.CategoryData;
import com.example.sachin.learnwithme.data.DataService;

import java.util.List;

public class CatActivity extends AppCompatActivity {
    Toolbar mToolbar;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d("Test", "Cat Activity ....tool bar");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if(id==R.id.action_settings){
            Intent intent = new Intent(CatActivity.this, UserProfile.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }


}

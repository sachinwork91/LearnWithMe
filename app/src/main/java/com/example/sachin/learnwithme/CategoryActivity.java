package com.example.sachin.learnwithme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sachin.learnwithme.data.Category;
import com.example.sachin.learnwithme.data.DataClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static android.widget.Toast.LENGTH_SHORT;

public class CategoryActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = (ListView)findViewById(R.id.pagination_list);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/saror061/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();

        DataClient client = retrofit.create(DataClient.class);
        Call<List<Category>> call= client.reposForUser();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> data = response.body();
                if(data==null){
                    Log.d("Test", "Empty Data Set ");
                }
                listView.setAdapter(new CategoryAdapter(CategoryActivity.this, data));
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Error in fetching data",  Toast.LENGTH_SHORT ).show();
            }
        });



    }

}

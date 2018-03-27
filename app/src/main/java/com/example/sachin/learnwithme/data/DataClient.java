package com.example.sachin.learnwithme.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sachin on 3/26/2018.
 */

public interface DataClient {

    @GET("test/master/category.json")
    Call<List<Category>> reposForUser();

}

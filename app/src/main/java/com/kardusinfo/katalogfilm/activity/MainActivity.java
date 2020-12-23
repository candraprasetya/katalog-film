package com.kardusinfo.katalogfilm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.kardusinfo.katalogfilm.R;
import com.kardusinfo.katalogfilm.adapter.MovieAdapter;
import com.kardusinfo.katalogfilm.api.Interface;
import com.kardusinfo.katalogfilm.models.Movie;
import com.kardusinfo.katalogfilm.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter recyclerAdapter;
    private List<Movie> movieModels;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_movie);
        linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Interface service= ApiService.getRetrofit().create(Interface.class);
        Call<List<Movie>> call=service.getMovieList();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                //loadProgress.setVisibility(View.GONE);
                movieModels=response.body();
                recyclerAdapter=new MovieAdapter(MainActivity.this,movieModels);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                //result.setText(t.getMessage());
            }
        });

    }
}
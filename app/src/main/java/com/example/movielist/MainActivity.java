package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.movielist.databinding.ActivityMainBinding;
import com.example.movielist.model.Search;
import com.example.movielist.model.SearchResponse;
import com.example.movielist.repository.MovieRepository;
import com.example.movielist.retrofitclient.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    List<Search> searchList=new ArrayList<>();
    private boolean loading = true;
    private int intPage=1;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        setAdapter();
        getMovieList(intPage,binding.textView.getText().toString().trim());
        setListeners();

    }

    private void setAdapter() {

        binding.setMyAdapter(new MovieListAdapter(this, searchList));
    }

    private void getMovieList(int intPage,String strMovie) {


        MovieRepository api = RetrofitClient.getClient().create(MovieRepository.class);
        Call<SearchResponse> call = api.getMovies(intPage, strMovie, "55d669e0");
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body().getSearch() != null) {

                    searchList.addAll(response.body().getSearch());
                    binding.recyclerView.getAdapter().notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });


    }


    private void setListeners(){


        binding.imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                intPage=1;
                searchList.clear();
                getMovieList(intPage,binding.textView.getText().toString().trim());
            }
        });


        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    System.out.println("*****************************");

                    intPage++;
                    progressDialog.show();
                    getMovieList(intPage,binding.textView.getText().toString().trim());

                }
            }
        });


    }

}
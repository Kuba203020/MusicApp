package com.example.kuba.musicappkuba.topsongs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.kuba.musicappkuba.R;
import com.example.kuba.musicappkuba.api.ApiService;
import com.example.kuba.musicappkuba.api.TrendingList;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsActivity extends AppCompatActivity {

    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvList = findViewById(R.id.rvList);

        Call<TrendingList> trendingListCall = ApiService. getService ().getTrendingList( "us" ,
                "itunes" , "singles" );
        trendingListCall.enqueue( new Callback<TrendingList>() {
            @Override
            public void onResponse(@NonNull Call<TrendingList> call, @NonNull
                    Response<TrendingList> response) {
                TrendingList trendingList;
                trendingList = response.body();
                Log. d ( "TAG" , new Gson().toJson(trendingList));
            }
            @Override
            public void onFailure( @NonNull Call<TrendingList> call, Throwable t) {
                Toast. makeText (TopSongsActivity. this , "Blad pobierania danych: " +
                        t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }
}

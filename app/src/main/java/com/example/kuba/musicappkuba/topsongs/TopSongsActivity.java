package com.example.kuba.musicappkuba.topsongs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.example.kuba.musicappkuba.R;
import com.example.kuba.musicappkuba.api.ApiService;
import com.example.kuba.musicappkuba.api.TrendingList;
import com.example.kuba.musicappkuba.api.TrendingSingle;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsActivity extends AppCompatActivity {

    RecyclerView rvList;
    List<TrendingSingle> singles = new ArrayList<>( 0 );
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
                TrendingList TrendingList;
                TrendingList = response.body();

                if(TrendingList !=null && TrendingList.trending != null) {
                    singles = TrendingList.trending;
                }

                setList();
            }
            @Override
            public void onFailure( @NonNull Call<TrendingList> call, Throwable t) {
                Toast. makeText (TopSongsActivity. this , "Blad pobierania danych: " +
                        t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();
            }
        });
    }

    private void setList() {
        TopSongsAdapter topSongsAdapter = new TopSongsAdapter(singles);
        rvList.setAdapter(topSongsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(  this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        rvList.setLayoutManager(linearLayoutManager);

        rvList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }
}

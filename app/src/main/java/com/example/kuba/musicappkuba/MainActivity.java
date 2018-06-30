package com.example.kuba.musicappkuba;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kuba.musicappkuba.R;
import com.example.kuba.musicappkuba.topsongs.TopSongsActivity;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button bTopSongs = findViewById(R.id.bTopSongs);
        bTopSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        TopSongsActivity.class);
                startActivity(intent);
            }


        });
    }
}

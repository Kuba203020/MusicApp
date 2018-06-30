package com.example.kuba.musicappkuba.topsongs;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kuba.musicappkuba.R;
import com.example.kuba.musicappkuba.api.ApiService;
import com.example.kuba.musicappkuba.api.Track;
import com.example.kuba.musicappkuba.api.Tracks;
import com.example.kuba.musicappkuba.database.Favorite;
import com.example.kuba.musicappkuba.databese.Favorite;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.*;

public class SongDetailsActivity extends AppCompatActivity {

    public static final String TRACK = "track" ;
    public static final String ARTIST = "artist" ;
    public static final String TRACK_ID = "track_id" ;

    String track;
    String artist;
    int trackId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        track = getIntent().getStringExtra(TRACK);
        artist = getIntent().getStringExtra(ARTIST);
        trackId = getIntent().getIntExtra(TRACK_ID, -1 );

        getSupportActionBar().setTitle(track);
        getSupportActionBar().setSubtitle(artist);
        ApiService. getService ().getTrack(trackId).enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(@NonNull Call<Tracks> call, @NonNull Response<Tracks>
                    response) {
                Tracks tracks = response.body();
                if (tracks != null && tracks. track .size() > 0 ) {
                    showData(tracks. track .get( 0 ));
                }
            }
            @Override
            public void onFailure( @NonNull Call<Tracks> call, @NonNull Throwable t) {
                makeText (
                        SongDetailsActivity. this ,
                        "Błąd pobierania danych: " + t.getLocalizedMessage(),
                        LENGTH_SHORT
                ).show();
            }
        });

    }

    private void showData(Track track) {
        TextView tvAlbum = findViewById(R.id. tvAlbum );
        TextView tvGenre = findViewById(R.id. tvGenre );
        TextView tvStyle = findViewById(R.id. tvStyle );
        TextView tvDescription = findViewById(R.id. tvDescription );
        tvAlbum.setText(track. strAlbum );
        tvGenre.setText(track. strGenre );
        tvStyle.setText(track. strStyle );
        tvDescription.setText(track. strDescriptionEN );

        if (track. strTrackThumb != null && !track. strTrackThumb .isEmpty()) {
            ImageView ivThumb = findViewById(R.id. ivThumb );
            Glide. with ( this ).load(track. strTrackThumb ).into(ivThumb);
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorite_menu, menu);
        return true;
    }

    private void addRemoveFavorite() {

        Realm realm = Realm. getDefaultInstance ();

        Favorite favorite = realm
                .where(Favorite. class )
                .equalTo( "trackId" , trackId )
                .findFirst();
        if (favorite == null ) {
// TODO brak w ulubionych
        } else {
// TODO istnieje w ulubionych
        }

    }

    private void addRemoveFavorite() {
...
        Realm realm;
        if (Favorite == null ) {
            addToFavorites(realm);
        } else {
            removeFromFavorites(realm, Favorite);
        }
    }
    ));
    private void addToFavorites(Realm realm) {
    }
    private void removeFromFavorites(Realm realm, final Favorite favorite) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemFavorite:
                addRemoveFavorite();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
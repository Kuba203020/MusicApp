package com.example.kuba.musicappkuba.topsongs;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kuba.musicappkuba.R;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater. from (parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs, parent, false );
        return new TopSongsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TopSongsViewHolder extends RecyclerView.ViewHolder{


        public TopSongsViewHolder(View itemView) {
            super(itemView);
        }
    }

}

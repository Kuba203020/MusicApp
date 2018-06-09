package com.example.kuba.musicappkuba.topsongs;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kuba.musicappkuba.R;
import com.example.kuba.musicappkuba.api.TrendingList;
import com.example.kuba.musicappkuba.api.TrendingSingle;

import java.util.List;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    private List<TrendingSingle> singles;

        public  TopSongsAdapter (List<TrendingSingle> singleList){

            this.singles = singles;
        }


    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater. from (parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs, parent, false );
        return new TopSongsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {

            TrendingSingle single = singles.get (position);

            holder.tvPlace.setText(String.valueOf(single.intChartPlace));
            holder.tvTrack.setText(single.strTrack);
            holder.tvArtist.setText(single.strArtist);
            holder.tvAlbum.setText(single.strAlbum);
    }

    @Override
    public int getItemCount() {
        return singles != null ? singles.size() : 0;
    }



    public class TopSongsViewHolder extends RecyclerView.ViewHolder{

        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbum;


        public TopSongsViewHolder(View itemView) {
            super(itemView);
            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);

        }



    }

}

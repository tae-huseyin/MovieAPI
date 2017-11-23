package com.example.theappexperts.movieapi.fragment.toprated;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theappexperts.movieapi.R;
import com.example.theappexperts.movieapi.model.topratedmovie.MovieList;

import java.util.List;

/**
 * Created by TheAppExperts on 23/11/2017.
 */

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.MyViewHolder> {

    public List<MovieList> movieListArrayList;
    public int top_rated_list;
    public Context appContext;

    public TopRatedAdapter(List<MovieList> movieListArrayList, int top_rated_list, Context appContext)
    {
        this.movieListArrayList = movieListArrayList;
        this.top_rated_list = top_rated_list;
        this.appContext = appContext;
    }

    @Override
    public TopRatedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(appContext).inflate(top_rated_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopRatedAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(movieListArrayList.get(position).getTitle().toString());
        holder.tvDate.setText(movieListArrayList.get(position).getId().toString());
    }

    @Override
    public int getItemCount() {
        return movieListArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView)itemView.findViewById(R.id.tvDate);
        }
    }
}

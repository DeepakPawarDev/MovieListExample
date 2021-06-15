package com.example.movielist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielist.databinding.MovieRowBinding;
import com.example.movielist.model.Search;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private Activity activity;
    private List<Search> searchList;
    private int lastSelectedPosition = -1;

    private MovieRowBinding binding;
    public MovieListAdapter(MainActivity mainActivity, List<Search> searchList) {
        this.activity= mainActivity;
        this.searchList=searchList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MovieRowBinding movieRowBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movie_row, parent, false);
        return new ViewHolder(movieRowBinding);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Search search=searchList.get(position);
        holder.binding.setMovie(search);
        holder.setImage(search);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        MovieRowBinding binding;
        public ViewHolder(MovieRowBinding movieRowBinding) {
            super(movieRowBinding.getRoot());
            this.binding=movieRowBinding;
        }

        private void setImage(Search search){

            Picasso.with(activity).load(search.getPoster()).into(binding.image);

        }
    }
}

package com.kardusinfo.katalogfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.kardusinfo.katalogfilm.R;
import com.kardusinfo.katalogfilm.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.kardusinfo.katalogfilm.utils.Constant.COVER_URL;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final Context context;
    private List<Movie> movieList;
    private Movie movieModel;
    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context=context;
        this.movieList=movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_card,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        movieModel=movieList.get(i);
        viewHolder.setMovieName.setText(movieModel.getTitle());
        viewHolder.setMovieDesc.setText(movieModel.getOverview());
        Picasso.get()
                .load( COVER_URL + movieModel.getPosterPath())
                .resize(100, 100)
                .into(viewHolder.setMovieCover);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView setMovieCover;
        private TextView setMovieName,setMovieDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setMovieName= itemView.findViewById(R.id.movieName);
            setMovieDesc=itemView.findViewById(R.id.movieDescription);
            setMovieCover=itemView.findViewById(R.id.movieCover);
        }
    }
}

package com.example.android.movieproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by itsidoadjavon on 8/3/17.
 */

public class MovieAdapter extends ArrayAdapter<MovieDescription> {


    public MovieAdapter(Context context, ArrayList<MovieDescription> objects) {
        super(context , 0, objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {


        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        MovieDescription movieAdapted = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.flavor_item, parent, false);
        }
        String picassoPath = movieAdapted.getMoviePath();
        ImageView iconView = (ImageView) convertView.findViewById(R.id.movie_image);
        Picasso.with(getContext()).load(picassoPath).into(iconView);

        //iconView.setImageResource(movieAdapted.getMoviePath());
        //Picasso.with(context).load(picassoPath).into(imageView)



        return convertView;

    }







}

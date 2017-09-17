package com.example.android.movieproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by itsidoadjavon on 8/3/17.
 */

public class MainActivityFragment extends Fragment {


   private String jsonResponse = Networkutil.getResponseFromHttpUrl(Networkutil.buildUrl());
   private ArrayList<MovieDescription> movies_Description_List = JsonParser.getSimpleJsonFromTheMovieDataBase(getContext(), jsonResponse );
    private MovieAdapter movies = null;

    public MainActivityFragment() throws IOException, JSONException {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the fragment xml
        View rootView = inflater.inflate(R.layout.flavor_item, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.movie_image);
      //  Picasso.with(getContext()).load(picassoPath).into(image );

        movies = new MovieAdapter(getContext(), movies_Description_List);

        // Get a reference to the ListView, and attach this adapter to it.
        GridView gridView = (GridView) rootView.findViewById(R.id.flavors_grid);
        gridView.setAdapter(movies);

        return rootView;
    }

}

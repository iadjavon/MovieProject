package com.example.android.movieproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.android.movieproject.JsonParser.getSimpleJsonFromTheMovieDataBase;
import static com.example.android.movieproject.Networkutil.buildUrl;

public class MainActivity extends AppCompatActivity {


    private static String dataReturnedFromUrl= null;
    private static ArrayList<MovieDescription> listOfMovie = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DisplayTask().execute(buildUrl());
    }


    public  class DisplayTask extends AsyncTask<URL,Void,ArrayList<MovieDescription>> {

        @Override
        protected ArrayList<MovieDescription> doInBackground(URL... params) {
            URL urls = params[0];

            try {
                dataReturnedFromUrl = Networkutil.getResponseFromHttpUrl(urls);

            } catch (IOException bad) {
                bad.printStackTrace();

            }
            try {
                return listOfMovie = getSimpleJsonFromTheMovieDataBase(getBaseContext(), dataReturnedFromUrl);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return listOfMovie;
        }


        protected void onPostExecute()

        {

            try {
                new MainActivityFragment();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


    }


}

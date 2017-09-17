package com.example.android.movieproject;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by itsidoadjavon on 8/1/17.
 */

public final class Networkutil {

    //HERE WE DEFINED THE STATIC VARIABLE THAT WLL MAKE UP THE URL.
    private static final String TAG = Networkutil.class.getSimpleName();

    private static final String BASE_URL = "http://api.themoviedb.org/3/";

    private static final String POP_MOVIES = "search/movie/popular";

    private static final String Top_Rated = "search/movie/top_rated";

    private static final String PIC_SIZES =
            "w185";
    final static String QUERY_PARAM = "?";

    private static final String API_KEY = "";//put your api key here

    private static final String   MOVIES_URL =
            "http://image.tmdb.org/t/p/";
    public static String response_From_Movie_Data_Base;

    /**
     * build url to talk to the tmdb database
     * @return The URL to use to query the weather server.
     */
    public static URL buildUrl() {
        // Here we built the uri that will serve to built the url
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(POP_MOVIES)
                .appendQueryParameter(QUERY_PARAM, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }

    }


}

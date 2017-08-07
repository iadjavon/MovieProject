package com.example.android.movieproject;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by itsidoadjavon on 8/1/17.
 */

public final class JsonParser {


   // String response_From_Movie_Data_Base = Networkutil.getResponseFromHttpUrl();
    public  final static  String response_From_Movie_Data_Base = null;

    /**
     * This method parses JSON from a web response and returns an array of Strings
     * describing the movie
     * <p/>
     * Later on, we'll be parsing the JSON into structured data within the
     * getFullMovieDataFromJson function, leveraging the data we have stored in the JSON.
     *
     * @param movieJsonStr JSON response from server
     *
     * @return Array of Strings describing weather data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static ArrayList<MovieDescription> getSimpleJsonFromTheMovieDataBase(Context context, String movieJsonStr )
            throws JSONException {

        /* Each information about the movie is an element of the value associated with the result field*/
        final String RESULT_FIELD = "results";

        //this string will allow us to determine if the network call procedded as expected or not
        final String HTTP_REQUEST_CODE = "cod";

        /* String array to hold movie data*/
        ArrayList<MovieDescription> parseMovieData = null;


        //PATH OF THE MOVIE PICTURE
         String POSTER_PATH = null;
        //this is a short description of the movie
         String OVERVIEW = null;
        //this field is for the release date
         String RELEASE_DATE ;
        //this is for the title of the movie
         String MOVIE_TITLE ;
        //this is the movie popularity
         String POPULARITY ;
        //this is for the number of vote that the movie received
         String VOTE ;

        //We are making a Json object properly parsed from the network request
        JSONObject MovieJson = new JSONObject(response_From_Movie_Data_Base );

        /* Is there an error? */
        if (MovieJson.has(HTTP_REQUEST_CODE)) {
            int errorCode = MovieJson.getInt(HTTP_REQUEST_CODE);

            switch (errorCode) {
                //here we get 200
                case HttpURLConnection.HTTP_OK:
                    break;
                //we got nothing back
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* Location invalid */
                    return null;
                default:
                    /* Server probably down */
                    return null;
            }
        }

        //here we retrieve the values of the field result in Json Object. They are many.
        JSONArray DataArray = MovieJson.getJSONArray(RESULT_FIELD);

        String[] field_Json_Array = new String[DataArray.length()];

        //we loop through each element of the Json object
        for (int i = 0; i < DataArray.length(); i++) {
            //We get the object at position i
            JSONObject movie_Description =
                    DataArray.getJSONObject(i);
            //we get the values from of the field passed as strings
            POSTER_PATH = movie_Description.getString("poster_path");
            OVERVIEW = movie_Description.getString("overview");
            RELEASE_DATE = movie_Description.getString("release_date");
            MOVIE_TITLE = movie_Description.getString("title");
            POPULARITY  = movie_Description.getString("popularity");
            VOTE  = movie_Description.getString("vote_count");
            //after we retrieve the field of interest we make a new movieDescription and add it to the arrayList
            parseMovieData.add(new MovieDescription(MOVIE_TITLE,VOTE,POSTER_PATH,OVERVIEW,RELEASE_DATE));

        }

        //we return a reference to a structure that countain the movie description object
        return parseMovieData;
    }





}

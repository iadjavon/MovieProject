package com.example.android.movieproject;

/**
 * Created by itsidoadjavon on 8/3/17.
 */

public class MovieDescription {

    private String movieTitle;
    private String movieRating;
    private String moviePath;
    private String movieOverview;
    private String movieReleasedate;

    public MovieDescription(String title, String rating, String path, String overview, String release){

        movieOverview = overview;
        moviePath = path;
        movieRating = rating;
        movieReleasedate = release;
    }

    /*
        This method returns the movie title
     */
    public String getMovieTitle(){

        return movieTitle;
    }
    /*
      This method return the picture path
     */
    public String getMoviePath(){

        return moviePath;
    }
    /*
    This method return the movie number of vote
     */
    public String getMovieRating(){

        return movieRating;
    }

    /*
    This method return the movie overview
     */
    public String getMovieOverview(){

        return movieOverview;
    }
    /*
    This movie returns the movie release date
     */
    public String getMovieReleasedate(){

        return movieReleasedate;
    }






}

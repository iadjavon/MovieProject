package com.example.android.movieproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;

import static com.example.android.movieproject.Networkutil.buildUrl;

public class MainActivity extends AppCompatActivity {

    static String jsonResponse = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DisplayTask().execute(buildUrl());
    }





//        private void makeGithubSearchQuery() {
//            String githubQuery = mSearchBoxEditText.getText().toString();
//            URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
//            mUrlDisplayTextView.setText(githubSearchUrl.toString());
//            String githubSearchResults = null;
//
//            new DisplayTask().execute(githubSearchUrl);
//            // TODO (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
//        }
        public class DisplayTask extends AsyncTask<URL,Void,String>{

            @Override
            protected String doInBackground(URL... params) {
                URL urls = params[0];

                try{
                    jsonResponse = Networkutil.getResponseFromHttpUrl(buildUrl());

                }catch(IOException bad){
                    bad.printStackTrace();

                }
                return jsonResponse;
            }
            @Override
            protected void onPostExecute(String str)  {
                

        }













}}

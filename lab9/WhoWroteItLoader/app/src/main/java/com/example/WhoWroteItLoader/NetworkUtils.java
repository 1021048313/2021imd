package com.example.WhoWroteItLoader;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    //log
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //google api
    // Base URL for Books API.
    private static final String BOOK_BASE_URL =  "https://sou.jiaston.com/search.aspx?";
    // Parameter for the key.
    private static final String KEY = "key";
    // Parameter page.
    private static final String PAGE = "page";
    // siteid
    private static final String SITE_ID = "siteid";


    //return json
    static String getBookInfo(String queryString){
        //connect internet
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;
        try{
//            System.out.println("try");
            //uri.builder
            Uri builtURI=Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(KEY,queryString)
                    .appendQueryParameter(PAGE,"1")
                    .appendQueryParameter(SITE_ID,"app2")
                    .build();
            //uri->url
            URL requestURL=new URL(builtURI.toString());

            //open url
            urlConnection=(HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            //response-ready
            InputStream inputStream=urlConnection.getInputStream();
            reader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder=new StringBuilder();
            //response-resolve:read line-by-line
            String line;
            while ((line=reader.readLine())!=null){
//                System.out.println("line"+line+"\n");
                builder.append((line));
                builder.append("\n");//only easy for debug
            }
            //check
            if (builder.length()==0){
                return null;
            }
            //builder->string
            bookJSONString=builder.toString();

        }
        catch (IOException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        finally {
            System.out.println("finally");
            //connection close
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
            //reader close
            if(reader!=null){
                try {
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
//        System.out.println("okk?\n");
//        System.out.println(bookJSONString);
        //log
        Log.d(LOG_TAG,bookJSONString);

        //return json
        return bookJSONString;


    }

}

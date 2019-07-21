package baxi.baxi.Service;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class apiClient {



    public static Retrofit login_link = null;

     public static Retrofit  getStorelink = null;


    private static String URL = "https://cerveapi-dev.herokuapp.com/";



    public static Retrofit getLoginClient(Context c){


        if(login_link == null){


            login_link = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();


        }



        return login_link;
    }



    public static  Retrofit  getStoreRequest(Context c){


        if(getStorelink == null){

            getStorelink =  new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();


        }


      return getStorelink;
    }















}

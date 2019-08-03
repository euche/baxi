package baxi.baxi.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;

import baxi.baxi.models.Cart;
import baxi.baxi.models.item;

public class userPref {


    private static String TOKEN_KEY = "token";

    private static String STORE_ID = "storeid" ;

    private static String BUSS_ID = "bussid";

    private static String TOTAL_PRICE = "total";



    public void storeuserToken(Context c, String t){

        SharedPreferences st = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor edit = st.edit();
        edit.putString(TOKEN_KEY,t);
        edit.apply();


    }



    public String getuserToken(Context c){

        SharedPreferences gp =  PreferenceManager.getDefaultSharedPreferences(c);

        return gp.getString(TOKEN_KEY,"");



    }


    public void setSTOREID(Context c, int s){

        SharedPreferences st = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor edit = st.edit();
        edit.putInt(STORE_ID,s);
        edit.apply();


    }

    public int getSTOREID(Context c){

        SharedPreferences gp = PreferenceManager.getDefaultSharedPreferences(c);

        return gp.getInt(STORE_ID,0);



    }





    public void setBussid(Context c, int b){

        SharedPreferences st = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor edit = st.edit();
        edit.putInt(BUSS_ID,b);
        edit.apply();


    }

    public int getBussid(Context c){

        SharedPreferences gp = PreferenceManager.getDefaultSharedPreferences(c);

        return gp.getInt(BUSS_ID,0);


    }


  public void setTP (Context c,float total){

      SharedPreferences st = PreferenceManager.getDefaultSharedPreferences(c);
      SharedPreferences.Editor edit = st.edit();
      edit.putFloat(TOTAL_PRICE,total);
      edit.apply();



  }


  public float getTP(Context c){

      SharedPreferences st = PreferenceManager.getDefaultSharedPreferences(c);

      return st.getFloat(TOTAL_PRICE,0);

  }
























}

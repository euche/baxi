package baxi.baxi.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class userPref {


    private static String TOKEN_KEY = "token";

    private static String STORE_ID = "storeid" ;

    private static String BUSS_ID = "bussid";



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



























}

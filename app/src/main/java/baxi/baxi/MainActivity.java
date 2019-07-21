package baxi.baxi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import baxi.baxi.Service.apiClient;
import baxi.baxi.Service.apiService;
import baxi.baxi.Utils.userPref;
import baxi.baxi.activities.mainPage;
import baxi.baxi.models.Business;
import baxi.baxi.models.Store;
import baxi.baxi.models.loginResponse;
import baxi.baxi.models.loginuser;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button login;

    private ProgressDialog dialog;

    private apiService connect;

    private AutoCompleteTextView phonenumber;

    private AutoCompleteTextView passwd;

    private loginuser user;

    private String token;

    private int storeid;

    private int bussid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       login = findViewById(R.id.login_process);

       phonenumber = findViewById(R.id.phoneInput);
       passwd = findViewById(R.id.passwordInput);


        connect = apiClient.getLoginClient(this).create(apiService.class);




       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String usernumber = phonenumber.getText().toString();
               String userpass = passwd.getText().toString();


               user = new loginuser(usernumber,userpass);

               authUser(user);
               movetoMainpage();
           }
       });


    }



    private void movetoMainpage(){

      Intent intent = new Intent(MainActivity.this,mainPage.class);
      startActivity(intent);


    }


    private void authUser(loginuser u){





//
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);




//         dialog = new ProgressDialog(MainActivity.this);
//         dialog.setMessage("Please Wait... ");
//         dialog.show();


        Call<loginResponse> loginResponseCall = connect.authenticateUser(u);


        loginResponseCall.enqueue(new Callback<loginResponse>() {
            @Override
            public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {

//              dialog.dismiss();




                if (response.isSuccessful()){
                    loginResponse loginResponse = response.body();


                    if(response.body().getSuccess() ){

                        token = response.body().getData().getToken();



                        Log.e("USertoken","SUCCESS "+token);


                        userPref pref = new userPref();

                        pref.storeuserToken(MainActivity.this,token);







                        List<Business> bList = response.body().getData().getUser().getBusinesses();


                        for(Business b : bList){


//                              List<Store> s = b.getStores();

                            for(Store s : b.getStores()){

                                 storeid = s.getId();

                                 bussid = s.getBusinessId();

                                 Log.e("Userstore", String.valueOf(storeid)+ " "+ String.valueOf(bussid));


                                 userPref storePref = new userPref();

                                 storePref.setSTOREID(MainActivity.this,storeid);

                                 storePref.setBussid(MainActivity.this,bussid);



                            }



                        }






                    }else{


                        Toast.makeText(MainActivity.this, "Invalid Username or Password",Toast.LENGTH_LONG).show();

                    }








                    Log.e("LLLLLL Success", loginResponse.toString());



                } else{
                    ResponseBody errorBody = response.errorBody();


                    Log.e("LLLLLL", "Not successfull "+errorBody.toString());
                }




;
//                      if(response.body().getSuccess()){
//
//
//                          Log.d("Baxilogin","success");
//
//
//                      }else{
//
//
//                          Log.d("Baxilogin","Invalid username or Password");
//
//
//                      }
//
//
//
//
//
//
//                  }catch(Exception e){
//
//
//                      Log.e("Error","Report:"+e.getMessage());
//
//
//                  }











            }

            @Override
            public void onFailure(Call<loginResponse> call, Throwable t) {

//                dialog.dismiss();

                Log.d("Baxilogin","Error connection issues"+ t.getMessage());


                Toast.makeText(MainActivity.this,"Check Network connectivity",Toast.LENGTH_LONG).show();


            }
        });


    }





}

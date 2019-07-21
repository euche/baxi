package baxi.baxi.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import baxi.baxi.R;
import baxi.baxi.Service.apiClient;
import baxi.baxi.Service.apiService;
import baxi.baxi.Utils.userPref;
import baxi.baxi.models.Datum;
import baxi.baxi.models.custResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class customerFragment extends Fragment {


    private static final int PAGE_START = 1;

    private boolean isLoading = false;
    private boolean isLastPage = false;

    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;

    private apiService api;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.frag_customer,container,false);


        return root;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);






        api = apiClient.getLoginClient(getContext()).create(apiService.class);

        loadFirstPage();

    }





    private Call<custResponse> getCustomersLIst(){


        userPref cid = new userPref();

        int getStoreid = cid.getSTOREID(getContext());

        int getBussid = cid.getBussid(getContext());

        String token = cid.getuserToken(getContext());

        Log.e("userprefCF","IDs "+ getStoreid+" "+getBussid);

        Call<custResponse> getCList = api.getCustomersList(getBussid,getStoreid,token,currentPage);

       return  getCList;


    }





    private void loadFirstPage(){


        getCustomersLIst().enqueue(new Callback<custResponse>() {
            @Override
            public void onResponse(Call<custResponse> call, Response<custResponse> response) {

                List<Datum> cList = response.body().getData();

                Log.e("custFragment", "Size of list"+cList.size());



            }

            @Override
            public void onFailure(Call<custResponse> call, Throwable t) {

                Log.e("custFragment","Error connection issues"+ t.getMessage());



            }
        });



    }




}

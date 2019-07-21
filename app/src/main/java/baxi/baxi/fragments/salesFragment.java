package baxi.baxi.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import baxi.baxi.R;
import baxi.baxi.Service.apiClient;
import baxi.baxi.Service.apiService;
import baxi.baxi.Utils.userPref;
import baxi.baxi.adapter.salesListAdapter;
import baxi.baxi.models.Product;
import baxi.baxi.models.Service;
import baxi.baxi.models.sDatasource;
import baxi.baxi.models.storeResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class salesFragment extends Fragment {



//    private sDatasource sds;

  private apiService api;

   private int getBussid;

   private int getStoreid;

    private CompositeDisposable storeDispose = new CompositeDisposable();

    private List<Product> pList1;

    private List<Service> sList1;

    private List<Object> combinedArray = new ArrayList<>();


    private RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.frag_sales,container,false);

        recyclerView = root.findViewById(R.id.product_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        return root;
    }







    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        api = apiClient.getStoreRequest(getContext()).create(apiService.class);

       userPref ad = new userPref();
      int a  = ad.getSTOREID(getContext());
       int b =  ad.getBussid(getContext());

        Log.e("salesFragmentPL"," IDs "+a+b);



        NetworkRequest();


    }



    private void NetworkRequest(){

        userPref gd = new userPref();

        getStoreid = gd.getSTOREID(getContext());
        getBussid =  gd.getBussid(getContext());
        String token = gd.getuserToken(getContext());

        Log.e("salesFragmentPL"," IDs "+getStoreid+getBussid+" " +token);

        storeDispose.add(

               api.getStoreitems(getBussid,getStoreid,token)
                   .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                     .subscribeWith(new DisposableSingleObserver<storeResponse>(){


                         @Override
                         public void onSuccess(storeResponse storeResponse) {

                             List<Product> pList = storeResponse.getData().getProducts();

                             Log.e("salesFragmentPL"," no of products"+pList.size());


                             List<Service> sList = storeResponse.getData().getServices();

                             Log.e("salesFragmentPL"," no of service"+sList.size());


                                pList1 = pList;
                                sList1 = sList;



//                                     combinedArray.add(pList1);
//                                     combinedArray.add(sList1);


                                     for(Product p : pList1){

                                         combinedArray.add(p);

                                     }

                                     for(Service s: sList1){

                                         combinedArray.add(s);

                                     }



                                 Log.e("Object","no of items"+ combinedArray.size());



                                 recyclerView.setAdapter(new salesListAdapter(getContext(),combinedArray));



                         }

                         @Override
                         public void onError(Throwable e) {

                             Log.e("salesFragmentPL",e.getMessage());

                         }
                     })

        );










    }





    @Override
    public void onDestroy() {
        super.onDestroy();

        storeDispose.dispose();
    }







}

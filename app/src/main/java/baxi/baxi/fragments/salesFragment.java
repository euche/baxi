package baxi.baxi.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import baxi.baxi.R;
import baxi.baxi.Service.apiClient;
import baxi.baxi.Service.apiService;
import baxi.baxi.Utils.userPref;
import baxi.baxi.activities.completsaleActivity;
import baxi.baxi.adapter.salesListAdapter;
import baxi.baxi.models.Cart;
import baxi.baxi.models.Product;
import baxi.baxi.models.Service;
import baxi.baxi.models.item;
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

    private Button cart;

    private salesListAdapter.salelistAdapterinterface info;

    private salesListAdapter sales;

    private String itemname;

    private float itemprice;

    private int itemquantity;

    private List<Cart> nextactive = new ArrayList<>();

    private String[] cartitems = new String[30];

    private ArrayList<String> cartitemss = new ArrayList<>();

    private ArrayList<String> cartitemsprice = new ArrayList<>();






    private item itemObject;

    private receiveCall rc;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.frag_sales,container,false);

        recyclerView = root.findViewById(R.id.product_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
         sales = new salesListAdapter(getContext(),combinedArray,info);



        cart = root.findViewById(R.id.checkCart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(getContext(),completsaleActivity.class);

                  Bundle b = new Bundle();

                  b.putStringArrayList("arraylist",cartitemss);
                  b.putStringArrayList("arrayprice",cartitemsprice);

                          //.putStringArray("arraylist",cartitems);
                 i.putExtras(b);
                getContext().startActivity(i);

//                cartList nextFrag= new cartList();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.cart_sales, nextFrag, "Fragment")
//                        .addToBackStack(null)
//                        .commit();




//           salesPicker();



            }
        });



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



//





        res();
    }


//    private void salesPicker() {
//
//        Dialog salesdialog = new Dialog(getContext());
//
//        it
//
//
//
//
//
//    }








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



//                                 recyclerView.setAdapter(new salesListAdapter(getContext(),combinedArray,info));

                                 recyclerView.setAdapter(sales);






                         }

                         @Override
                         public void onError(Throwable e) {

                             Log.e("salesFragmentPL",e.getMessage());

                         }
                     })

        );










    }


    public void res(){

        info = new salesListAdapter.salelistAdapterinterface() {
            @Override
            public void onItemnameclicked(String name) {


                Log.e("Transfer ",name);

                itemname = name;




                  cartitemss.add(name);






                Log.e("cartitems",""+cartitemss.size()+itemname);


            }

            @Override
            public void onItemprice(float price) {

                itemprice = price;

                cartitemsprice.add(String.valueOf(price));
            }

            @Override
            public void ontItemquantity(int quantity) {

                itemquantity = quantity;
            }
        };


        itemObject = new item (itemname,itemprice,itemquantity);




        nextactive.add(new Cart(itemObject,1));


    }




    @Override
    public void onDestroy() {
        super.onDestroy();

        storeDispose.dispose();
    }







    public interface  receiveCall{

        void serialItem(item m);

        void serialItemname(String h);

    }




}

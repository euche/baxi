package baxi.baxi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import baxi.baxi.R;
import baxi.baxi.adapter.salesListAdapter;


public class cartList extends DialogFragment {


    salesListAdapter i;

    private salesListAdapter.salelistAdapterinterface info;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.sales_dialog, container, false);


        return root;



    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        Bundle mArgs = getArguments();
//        String myValue = mArgs.getString("productName");
//        float myValue1 = mArgs.getFloat("productPrice");
//
//
//        Toast.makeText(getContext(),"Bundle"+myValue+" "+myValue1,Toast.LENGTH_SHORT).show();


        info = new salesListAdapter.salelistAdapterinterface() {
            @Override
            public void onItemnameclicked(String name) {

                Toast.makeText(getContext(),"carList "+name+" ",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemprice(float price) {

            }

            @Override
            public void ontItemquantity(int quantity) {

            }
        };

    }






}

package baxi.baxi.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baxi.baxi.R;
import baxi.baxi.Utils.userPref;
import baxi.baxi.adapter.cartAdapter;
import baxi.baxi.adapter.salesListAdapter;
import baxi.baxi.fragments.salesFragment;
import baxi.baxi.models.Cart;
import baxi.baxi.models.cartOrder;
import baxi.baxi.models.item;

public class completsaleActivity extends AppCompatActivity  {






    List<item> cartList1 = new ArrayList<>();




    private cartAdapter.cartAdapterinterface info;





    String name1;


    private String sname,pname;

    private float sprice,pprice;

    private int squantity, pquantity;


    private TextView finalprice;


     private Button addTotal;


     private Button sendReceipt;

     String[] paymentTypes;

     int paymentOption;







    List<Cart> cartorder = new ArrayList<>();

    private RecyclerView rv,rc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completsale);


        paymentTypes = getResources().getStringArray(R.array.payment_type);

        finalprice = findViewById(R.id.totalprice);

        addTotal = findViewById(R.id.add_total);

        sendReceipt = findViewById(R.id.send_receipt);



        rv = findViewById(R.id.cart_recycler_list);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);

       final cartAdapter s = new cartAdapter(this,cartorder);

        salesFragment sd = new salesFragment();

          sd.res();




        LocalBroadcastManager.getInstance(this).registerReceiver(productResult,new IntentFilter("item_receive"));

        LocalBroadcastManager.getInstance(this).registerReceiver(serviceResult,new IntentFilter("item_receive1"));








        ArrayList<String> h = getIntent().getStringArrayListExtra("arraylist");

        ArrayList<String> j = getIntent().getStringArrayListExtra("arrayprice");

        Log.e("LOg something"," length"+h.size()+" "+j.size());


        for(String part : h){

            Log.e("LOGGER",part);


        }


        for(int i = 0;i< j.size();i++){

            Log.e("Logger","price"+j.get(i));


            cartorder.add(new Cart(new item(h.get(i),Float.valueOf(j.get(i)),0),1));


        }


        Log.e("Cartoreder","no of carts"+cartorder.size());



              rv.setAdapter(s);






        addTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(cartorder.size()!=s.getItemCount()){


                  finalprice.setText(String.valueOf(getTotalPrice()));

              }else{


                  finalprice.setText(String.valueOf(s.getTotalPrice()));

              }




            }
        });




        sendReceipt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder sPaymentoption = new AlertDialog.Builder(completsaleActivity.this);
                sPaymentoption.setTitle("Select Payment option");

                sPaymentoption.setSingleChoiceItems(paymentTypes, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        paymentOption = which;

                        Log.e(" Dialog"," Service name "+ paymentOption);

                    }
                });

                sPaymentoption.setCancelable(false);
                sPaymentoption.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                sPaymentoption.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Log.e(" Dialog1"," payment option "+ paymentOption);



                    }
                });


                sPaymentoption.create();
                sPaymentoption.show();




            }
        });




    }




    public float getTotalPrice(){

        float totalPrice = 0;
        for (int i = 0; i < cartorder.size(); i++) {
            totalPrice += cartorder.get(i).getItem().getPrice1();
        }
        return totalPrice;




    }









    public BroadcastReceiver productResult = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String itemname = intent.getStringExtra("productName");
            float itemprice = intent.getFloatExtra("productPrice",0);
            int itemquantity = intent.getIntExtra("productQuantity",0);


            Toast.makeText(completsaleActivity.this," Order "+itemname+" "+itemprice+" "+itemquantity,Toast.LENGTH_SHORT).show();


            Log.e("FFFFF","???"+itemname+itemprice+itemquantity);



            pname = itemname;
            pprice = itemprice;
            pquantity = itemquantity;


            cartList1.add(new item(pname,pprice,pquantity));

//            connecttoList();









        }
    };






    public BroadcastReceiver serviceResult = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

             String itemname = intent.getStringExtra("serviceName");
             int itemprice = intent.getIntExtra("servicePrice",0);
             int itemquantity = intent.getIntExtra("serviceQuantity",0);



               float ip = (float)itemprice;


            Toast.makeText(completsaleActivity.this," Order "+itemname+" "+ip+" "+itemquantity,Toast.LENGTH_SHORT).show();


            Log.e("FFFFF","???"+itemname+itemprice+itemquantity);

           sname = itemname;
           sprice = ip;
           squantity = itemquantity;


            cartList1.add(new item(sname,sprice,squantity));

//            connecttoList();

        }
    };










}



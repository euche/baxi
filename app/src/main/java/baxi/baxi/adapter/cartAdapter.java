package baxi.baxi.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baxi.baxi.R;
import baxi.baxi.Utils.userPref;
import baxi.baxi.models.Cart;
import baxi.baxi.models.cartOrder;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartviewHolder> {


    Context context;
    List<Cart> cartData;

    final ArrayList<Float> totalprice = new ArrayList();

    private cartAdapterinterface infos;





    public cartAdapter(Context c, List<Cart> cartData) {
        this.context = c;
        this.cartData = cartData;
    }


    public static class cartviewHolder extends RecyclerView.ViewHolder{

        private TextView cartname;
        private TextView cartprice;
        private TextView itemfinalprice;
        private AutoCompleteTextView itemquantity;
        private ImageButton add;

        private ImageButton remove;




        cartviewHolder(View v){

            super(v);


            cartname = v.findViewById(R.id.item_name);
            cartprice = v.findViewById(R.id.item_price);
            itemfinalprice = v.findViewById(R.id.final_price);
            itemquantity = v.findViewById(R.id.item_quantity);
            add = v.findViewById(R.id.add_quantity);
            remove = v.findViewById(R.id.item_remove);



        }



    }




    @Override
    public cartAdapter.cartviewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        View itemview =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_listing,viewGroup,false);


        return new cartAdapter.cartviewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final cartAdapter.cartviewHolder cartviewHolder, final int position) {

        final Cart c = cartData.get(position);






        cartviewHolder.cartname.setText(c.getItem().getName());
        cartviewHolder.cartprice.setText(String.valueOf(c.getItem().getPrice1()));
        cartviewHolder.itemquantity.setText(String.valueOf(c.getQuantity()));
        cartviewHolder.itemfinalprice.setText(String.valueOf(c.getQuantity()*c.getItem().getPrice1()));
        cartviewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                float t = Float.valueOf( cartviewHolder.itemquantity.getText().toString());
//
//
//
//                cartviewHolder.itemfinalprice.setText(String.valueOf(t*c.getItem().getPrice1()));
//
//                 float ans = t*c.getItem().getPrice1();



            }
        });

        cartviewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                remove(c);

                notifyItemRemoved(position);
            }
        });



    }

    public void setData(List<Cart> items) {
        this.cartData = items;
        notifyDataSetChanged();
    }



    public float getTotalPrice(){

        float totalPrice = 0;
        for (int i = 0; i < cartData.size(); i++) {
            totalPrice += cartData.get(i).getItem().getPrice1();
        }
        return totalPrice;




    }

    public  void remove(Cart c){

        cartData.remove(c);

        notifyDataSetChanged();

    }







    @Override
    public int getItemCount() {


        return cartData.size();
    }



    public interface cartAdapterinterface{

        void onitemClick(float p);

        void tryer(float f);



    }





}




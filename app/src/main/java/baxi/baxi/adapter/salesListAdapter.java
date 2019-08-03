package baxi.baxi.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import baxi.baxi.R;
import baxi.baxi.fragments.cartList;
import baxi.baxi.models.Product;
import baxi.baxi.models.Service;

public class salesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   private Context c;
   private List<Object> salesdata;


   private salelistAdapterinterface info;


   private final int PRODUCT = 0;
   private final int SERVICE = 1;

    public salesListAdapter(Context c, List<Object> salesdata,salelistAdapterinterface i) {
        this.c = c;
        this.salesdata = salesdata;
        this.info = i;
    }


    public salesListAdapter(Context c,salelistAdapterinterface j){

        this.c = c;
       this.info = j;

    }



    public static class productviewHolder extends RecyclerView.ViewHolder{


        private TextView prodctItemname;
        private TextView productItemprice;
        private ImageView productItemimage;
        private CardView cardview;



        productviewHolder(View v){

            super(v);


            prodctItemname = v.findViewById(R.id.product_item_name);
            productItemprice = v.findViewById(R.id.product_item_price);
            productItemimage  = v.findViewById(R.id.product_item_image);
            cardview = v.findViewById(R.id.proc_card);

        }



    }




    public static class serviceviewHolder extends RecyclerView.ViewHolder{

        private TextView servItemname;
        private TextView servtItemprice;
        private ImageView servItemimage;
        private CardView cardview1;



        serviceviewHolder(View v){

            super(v);
            servItemname = v.findViewById(R.id.serv_item_name);
            servtItemprice = v.findViewById(R.id.serv_item_price);
            servItemimage = v.findViewById(R.id.serv_item_image);
            cardview1 = v.findViewById(R.id.serv_card);

        }




    }







    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewtype) {


        RecyclerView.ViewHolder vh;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

          if(viewtype == PRODUCT){

              View v1 = inflater.inflate(R.layout.product_card,viewGroup,false);
                vh = new productviewHolder(v1);

          }else{

              View v2 = inflater.inflate(R.layout.service_card,viewGroup,false);
                vh =  new serviceviewHolder(v2);

          }






        return vh;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int position) {






       switch (viewHolder.getItemViewType()){

           case PRODUCT:

               productviewHolder p = (productviewHolder)viewHolder;
               setProductview(p,position);

               break;
           case SERVICE:

               serviceviewHolder s = (serviceviewHolder)viewHolder;
               setServiceview(s,position);

               break;

            default:

                break;






       }





    }


private void setProductview(productviewHolder viewHolder, int position){

//        Object item = salesdata.get(position);

        final Product p = (Product)salesdata.get(position);


        viewHolder.prodctItemname.setText(p.getName());
        viewHolder.productItemprice.setText(String.valueOf(p.getPrice()));

        Picasso.with(c).load(p.getImageUrl()).into(viewHolder.productItemimage);

        viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("item_receive");
                i.putExtra("productName",p.getName());
                i.putExtra("productPrice",p.getPrice());
                i.putExtra("productQuantity",p.getQuantity());



//                LocalBroadcastManager.getInstance(c).sendBroadcast(i);


                info.onItemnameclicked(p.getName());
                info.onItemprice(p.getPrice());
                info.ontItemquantity(1);


                String order = p.getName();


                Toast.makeText(c,order +" has been added ",Toast.LENGTH_SHORT).show();


            }
        });


}


private void setServiceview(serviceviewHolder serviceviewHolder, int position){


       final Service s = (Service)salesdata.get(position);

        serviceviewHolder.servItemname.setText(s.getName());
        serviceviewHolder.servtItemprice.setText(String.valueOf(s.getPrice()));

        Picasso.with(c).load(s.getImageUrl()).into(serviceviewHolder.servItemimage);

      serviceviewHolder.cardview1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent i = new Intent("item_receive1");
              i.putExtra("serviceName",s.getName());
              i.putExtra("servicePrice",s.getPrice());
              i.putExtra("serviceQuantity",s.getQuantity());



//              LocalBroadcastManager.getInstance(c).sendBroadcast(i);

              info.onItemnameclicked(s.getName());
              info.onItemprice((float)s.getPrice());
              info.ontItemquantity(1);



              String order = s.getName();


              Toast.makeText(c,order +" has been added ",Toast.LENGTH_SHORT).show();



//              getItem.sendService(s.getName(),s.getPrice(),s.getQuantity());

//              c.startActivity(i);

          }
      });


}









    @Override
    public int getItemCount()
    {
        return salesdata.size();


    }

    @Override
    public int getItemViewType(int position) {

      if(salesdata.get(position) instanceof Product){


         return PRODUCT;

      }else if(salesdata.get(position)instanceof Service){



          return SERVICE;
      }



       return -1;

    }



    public interface  salelistAdapterinterface{

        void onItemnameclicked(String name);

        void onItemprice(float price);

        void ontItemquantity(int quantity);

    }






}

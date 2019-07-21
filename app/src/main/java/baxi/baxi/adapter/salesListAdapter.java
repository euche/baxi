package baxi.baxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import baxi.baxi.R;
import baxi.baxi.models.Product;
import baxi.baxi.models.Service;
import baxi.baxi.models.sDatasource;

public class salesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   private Context c;
   private List<Object> salesdata;

   private final int PRODUCT = 0;
   private final int SERVICE = 1;

    public salesListAdapter(Context c, List<Object> salesdata) {
        this.c = c;
        this.salesdata = salesdata;
    }






    public static class productviewHolder extends RecyclerView.ViewHolder{


        private TextView prodctItemname;
        private TextView productItemprice;
        private ImageView productItemimage;



        productviewHolder(View v){

            super(v);


            prodctItemname = v.findViewById(R.id.product_item_name);
            productItemprice = v.findViewById(R.id.product_item_price);
            productItemimage  = v.findViewById(R.id.product_item_image);

        }



    }




    public static class serviceviewHolder extends RecyclerView.ViewHolder{

        private TextView servItemname;
        private TextView servtItemprice;
        private ImageView servItemimage;



        serviceviewHolder(View v){

            super(v);
            servItemname = v.findViewById(R.id.serv_item_name);
            servtItemprice = v.findViewById(R.id.serv_item_price);
            servItemimage = v.findViewById(R.id.serv_item_image);


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



//        switch(viewtype){
//
//            case PRODUCT:
//
//                View v1 = inflater.inflate(R.layout.product_card,viewGroup,false);
//                vh = new productviewHolder(v1);
//
//                break;
//            case SERVICE:
//
//                View v2 = inflater.inflate(R.layout.service_card,viewGroup,false);
//                vh =  new serviceviewHolder(v2);
//
//                break;
//
//            default:
//
//                vh = null;
//                break;
//
//
//
//        }




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

        Product p = (Product)salesdata.get(position);


        viewHolder.prodctItemname.setText(p.getName());
        viewHolder.productItemprice.setText(String.valueOf(p.getPrice()));

        Picasso.with(c).load(p.getImageUrl()).into(viewHolder.productItemimage);


}


private void setServiceview(serviceviewHolder serviceviewHolder, int position){


        Service s = (Service)salesdata.get(position);

        serviceviewHolder.servItemname.setText(s.getName());
        serviceviewHolder.servtItemprice.setText(String.valueOf(s.getPrice()));

        Picasso.with(c).load(s.getImageUrl()).into(serviceviewHolder.servItemimage);



}








    //   picasso.with(c)
////                .load(m.getPosterPath())
////                .into(holder.movieimage);
//
//
//    }


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






}

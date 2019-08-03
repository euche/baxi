package baxi.baxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import baxi.baxi.R;
import baxi.baxi.models.Datum;

public class custListAdapter extends RecyclerView.Adapter<custListAdapter.custviewHolder> {


    Context c;

    List<Datum> cData;


    public custListAdapter(Context c, List<Datum> cData) {

        this.c = c;
        this.cData = cData;

    }


    public static  class custviewHolder extends RecyclerView.ViewHolder{

      private TextView custname;

      private TextView custphoneno;


      custviewHolder(View v){


          super(v);

          custname = v.findViewById(R.id.customer_name);
          custphoneno = v.findViewById(R.id.customer_phoneno);



      }



    }



    @Override
    public custviewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_list_card,viewGroup,false);


        return new custviewHolder(itemview);
    }




    @Override
    public void onBindViewHolder( custviewHolder custviewHolder, int i) {

         Datum d = cData.get(i);

         custviewHolder.custname.setText(d.getName());
         custviewHolder.custphoneno.setText(d.getPhoneNumber());


    }



    @Override
    public int getItemCount() {

        return cData.size();

    }
}

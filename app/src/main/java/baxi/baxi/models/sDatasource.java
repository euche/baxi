package baxi.baxi.models;

import java.util.ArrayList;
import java.util.List;

public class sDatasource {

    int type; //1 is product and 2 is for service

    public Product p;

    public Service s;


    public List<sDatasource> merge(List<Product> item1,List<Service> item2){

        List<sDatasource> data = new ArrayList<>();

        for(Product product : item1){

            sDatasource d =  new sDatasource();
            d.p = product;
            d.s = null;
            d.type = 1;

            data.add(d);


        }


        for(Service service : item2){

            sDatasource d = new sDatasource();

            d.p = null;
            d.s = service;
            d.type = 2;

            data.add(d);



        }



       return data;

    }



}

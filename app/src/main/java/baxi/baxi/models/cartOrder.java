package baxi.baxi.models;


import java.util.ArrayList;
import java.util.List;

public class cartOrder {



    public static List<Cart> items = new ArrayList<>();


    public static void insert(Cart item){

       items.add(item);


    }


    public static void update(item i){

        int index = getIndex(i);



        int quantity = items.get(index).getQuantity() + 1;

        items.get(index).setQuantity(quantity);


    }







    public static void remove(Cart item){//sketchy

        items.remove(item);

    }




    public static double total() {



        double sum = 0;

        for (Cart c : items) {

            sum += c.getItem().price1 * c.getQuantity();


        }
        return sum;

    }




    private static int getIndex(item m){

     for(int i = 0;i<items.size();i++){

         if(items.get(i).getItem().product.getId() == m.product.getId()){

             return i;
         }else if(items.get(i).getItem().service.getId() == m.service.getId()){

             return i;

         }


     }



        return -1;
    }



    private static boolean isExists(item m){

        return  getIndex(m) != -1;

    }















}

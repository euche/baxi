package baxi.baxi.models;

import java.io.Serializable;

public class item  {


    String name;
    int price;
    int quantity;
    float price1;

    float price2;


    Product product;
    Service service;




    public item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public item(String name, float price1, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price1 = price1;
    }



//    public float changeProductprice(String name){
//
//        float a;
//
//        //== product.getName()
//
//        if(name.equalsIgnoreCase(product.getName()) ){
//
//            return a = product.getPrice();
//
//
//        }else{
//
//            return a = (float) price;
//
//        }
//
//
//
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }









}

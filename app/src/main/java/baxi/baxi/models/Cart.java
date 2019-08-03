package baxi.baxi.models;

import java.io.Serializable;

public class Cart implements Serializable  {

    private item item;

    private int quantity;


    public Cart(baxi.baxi.models.item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }



    public Cart(){

    }


    public baxi.baxi.models.item getItem() {
        return item;
    }

    public void setItem(baxi.baxi.models.item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}









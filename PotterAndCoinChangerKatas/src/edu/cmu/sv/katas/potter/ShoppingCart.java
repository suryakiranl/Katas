package edu.cmu.sv.katas.potter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Surya Kiran on 2/19/14.
 */
public class ShoppingCart {
    private static final int COST_PER_BOOK = 8;

    private int copiesOfBook1;
    private int copiesOfBook2;
    private int copiesOfBook3;
    private int copiesOfBook4;
    private int copiesOfBook5;

    public int getCopiesOfBook1() {
        return copiesOfBook1;
    }
    public void setCopiesOfBook1(int copiesOfBook1) {
        this.copiesOfBook1 = copiesOfBook1;
    }
    public int getCopiesOfBook2() {
        return copiesOfBook2;
    }
    public void setCopiesOfBook2(int copiesOfBook2) {
        this.copiesOfBook2 = copiesOfBook2;
    }
    public int getCopiesOfBook3() {
        return copiesOfBook3;
    }
    public void setCopiesOfBook3(int copiesOfBook3) {
        this.copiesOfBook3 = copiesOfBook3;
    }
    public int getCopiesOfBook4() {
        return copiesOfBook4;
    }
    public void setCopiesOfBook4(int copiesOfBook4) {
        this.copiesOfBook4 = copiesOfBook4;
    }
    public int getCopiesOfBook5() {
        return copiesOfBook5;
    }
    public void setCopiesOfBook5(int copiesOfBook5) {
        this.copiesOfBook5 = copiesOfBook5;
    }

    @Override
    public String toString() {
        return "ShoppingCart[" + copiesOfBook1 + "," + copiesOfBook2 + "," + copiesOfBook3
                + "," + copiesOfBook4 + "," + copiesOfBook5 + "]";
    }

    public Integer[] getAsArray() {
        List<Integer> cartItems = new ArrayList<Integer>();
        if(copiesOfBook1 > 0) { cartItems.add(copiesOfBook1); }
        if(copiesOfBook2 > 0) { cartItems.add(copiesOfBook2); }
        if(copiesOfBook3 > 0) { cartItems.add(copiesOfBook3); }
        if(copiesOfBook4 > 0) { cartItems.add(copiesOfBook4); }
        if(copiesOfBook5 > 0) { cartItems.add(copiesOfBook5); }

        Integer[] items = {};
        return cartItems.toArray(items);
    }

    public int countItemsInCart() {
        return copiesOfBook1 + copiesOfBook2 + copiesOfBook3 + copiesOfBook4 + copiesOfBook5;
    }

    public ShoppingCart makeACopy() {
        ShoppingCart copy = new ShoppingCart();
        copy.setCopiesOfBook1(this.getCopiesOfBook1());
        copy.setCopiesOfBook2(this.getCopiesOfBook2());
        copy.setCopiesOfBook3(this.getCopiesOfBook3());
        copy.setCopiesOfBook4(this.getCopiesOfBook4());
        copy.setCopiesOfBook5(this.getCopiesOfBook5());

        return copy;
    }
}

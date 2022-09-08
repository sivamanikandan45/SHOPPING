package com.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    private double amount;
    private ArrayList <Product> selectedList=new ArrayList<>();

    public boolean addToCart(ArrayList<Product> list,int pid){
        //adds the product to the cart and returns true if it is added successfully else false
        Product new1=list.get(pid-1);
        selectedList.add(new1);
        this.amount+=new1.getAmount();
        Collections.sort(selectedList, Comparator.comparingLong(Product::getId));
        return true;
    }

    public boolean removeProduct(ArrayList<Product> list,int pid){
        //removes the product from the card and returns true if it is removed successfully else false
        if(this.selectedList.isEmpty()){
            return false;
        }else{
            Product new1=list.get(pid-1);
            this.amount-= new1.getAmount();
            selectedList.remove(new1);
            return true;
        }
    }

    public boolean removeAll(){
        //returns true after removing all items
        if(this.selectedList.isEmpty()){
            return false;
        }
        else {
            selectedList.clear();
            this.amount = 0;
            return true;
        }
    }

    public boolean searchProduct(int pid){
        //searches the product and returns true if it is present in the cart
        for (Product p : selectedList) {
            if ((p.getId())==(pid)){
                return true;
            }
        }
        return false;
    }

    public boolean clear(){
        //clears the Cart details
        this.selectedList.clear();
        this.amount=0;
        return true;
    }

    public double getAmount(){
        //returns amount
        return this.amount;
    }

    public ArrayList<Product> getCart(){
        return this.selectedList;
    }

}

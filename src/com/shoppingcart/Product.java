package com.shoppingcart;

public class Product {
    private int productId;
    private String productName;
    private double amount;

    public  Product(int pid,String name,int amt){
        this.productId =pid;
        this.productName =name;
        this.amount=amt;
    }

    public double getAmount(){
            return this.amount;
        }

    public String getName(){
        return this.productName;
    }

    public int getId(){
       return this.productId;
    }

}

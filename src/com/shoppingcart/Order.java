package com.shoppingcart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {
    //public enum Status { DISPATCHED, DELIVERED,OUT_FOR_DELIVERY}
    private int ordNo = (int)(Math.random()*(Integer.MAX_VALUE-10000000+1)+10000000);
    private String address, customerName, ordDate, deliveryDate;
    private double amount;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Order(String cusName,String address){
        //constructor to initialize data members
        this.customerName =cusName;
        this.address=address;
    }

    public Order placeOrder(Cart cart){
        //returns Order details and initializes details array;
            Date date = new Date();
            ordDate =formatter.format(date);
            amount=cart.getAmount();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date()); // Using today's date
            cal.add(Calendar.DATE, 2); // Adding 2 days
            deliveryDate =formatter.format(cal.getTime());
            return this;
    }

public int getOrdNo(){
        //returns orderNo
        return this.ordNo;
}

    public boolean cancelOrder(ArrayList<Order> list,int ordId){
        //returns true if order cancelled successfully
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getOrdNo()==(ordId)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Order ID:\t" + ordNo +
                "\nAddress:\t'" + address + '\'' +
                "\nCustomer Name:\t'" + customerName + '\'' +
                "\nOrder Date:\t'" + ordDate + '\'' +
                "\nDelivery Date:\t'" + deliveryDate + '\'' +
                "\nAmount:\t" + amount;
    }

    public double getAmount(){
        return this.amount;
    }

}

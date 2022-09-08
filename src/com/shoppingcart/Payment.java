package com.shoppingcart;

public interface Payment {
    boolean doPayment(String id, int pin,double amount);
    double calculatePayment(Cart c);
    //boolean isValid(String id, int pin);
}

    /*public double refundAmount(ArrayList<Order> list, int oid){
        //returns amount
        for (Order order : list) {
            if (order.getOrdNo()==(oid)) {
                //OrderList.ord_list.remove(i);
                return order.getAmount();
            }
        }
        //return false;
        return amount;
    }*/


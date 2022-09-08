package com.shoppingcart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UPIPayment implements Payment{
    private double amount;
    @Override
    public boolean doPayment(String id,int pin,double amount){
        //returns true if payment is successful else false
        Pattern p = Pattern.compile("[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}");//. represents single character
        Matcher m = p.matcher(id);
        return m.matches()&&(String.valueOf(pin).length()==6||String.valueOf(pin).length()==4);
    }
    public double calculatePayment(Cart c){
        //returns amount
        this.amount=c.getAmount();
        return amount;
    }

    /*public boolean isValid(String id, int pin) {
        Pattern p = Pattern.compile("[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}");//. represents single character
        Matcher m = p.matcher(id);
        return m.matches()&&String.valueOf(pin).length()==6;
    }*/
}

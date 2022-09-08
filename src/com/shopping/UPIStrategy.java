package com.shopping;

import com.shoppingcart.Cart;
import com.shoppingcart.Payment;
import com.shoppingcart.UPIPayment;

import java.util.Scanner;

public class UPIStrategy implements Strategy{
    Scanner sc=new Scanner(System.in);
    public void execute(Cart cart) {
        Payment pay;
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter UPI ID:");
            //sc.nextLine();
            String id = sc.nextLine();
            int pin;
            //int pin = sc.nextInt();
            while (true) {
                System.out.println("Enter UPI Pin:");
                if (sc.hasNextInt()) {
                    //return sc.nextInt();
                    pin = sc.nextInt();
                    break;
                } else {
                    System.out.println("Enter valid pin!!");
                    sc.next();
                }
            }
            pay = new UPIPayment();
            double amt = pay.calculatePayment(cart);
            valid = pay.doPayment(id, pin, amt);
            if (valid) {
                System.out.println("Payment successful\nBill amount Rs." + cart.getAmount() + " is debited from your account");
                if (cart.clear()) {

                }
            } else {
                System.out.println("Re-Enter the Valid details");
            }
        }
    }
}
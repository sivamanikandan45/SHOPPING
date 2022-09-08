package com.shopping;

import com.shoppingcart.Cart;
import com.shoppingcart.CreditCardPayment;
import com.shoppingcart.Payment;

import java.util.Scanner;

public class CardStrategy implements Strategy{
    //private final com.shopping.UI sc;
    Scanner sc;
    public CardStrategy() {
        //this.sc = UI;
        this.sc = new Scanner(System.in);
    }

    public void execute(Cart cart) {
        Payment pay;
        int cvv;
        boolean valid = false;
        while (!valid) {
            System.out.println("---Enter your card details---\nEnter Card Number:");
            sc.nextLine();
            String card_no = sc.nextLine();
            while (true) {
                System.out.println("Enter CVV:");
                if (sc.hasNextInt()) {
                    //return sc.nextInt();
                    cvv = sc.nextInt();
                    break;
                } else {
                    System.out.println("Enter valid CVV!!");
                    sc.next();
                }
            }
            //System.out.println("Enter CVV");

            pay = new CreditCardPayment();
            double amt = pay.calculatePayment(cart);
            valid = pay.doPayment(card_no, cvv, amt);
            if (valid) {
                System.out.println("Payment successful\nBill amount Rs." + cart.getAmount() + " is debited from your account");
                if (cart.clear()) {

                }
            } else {
                System.out.println("Re-Enter the Valid Master/VISA Card details");
            }
        }
    }
}
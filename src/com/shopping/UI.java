package com.shopping;

import com.shoppingcart.*;

import java.util.*;

public class UI {
    private final UPIStrategy UPIStrategy = new UPIStrategy();
    private final CardStrategy cardStrategy = new CardStrategy();
    private HashMap<Integer,Strategy> a=new HashMap<Integer,Strategy>(){
        {
            put(1, UPIStrategy);
            put(2, cardStrategy);
        }
    };

    Scanner sc=new Scanner(System.in);
    public int displayHome(){
        //boolean valid=false;
        while(true){
            System.out.println("*** Welcome to Shopping Cart ***");
            System.out.println("Select option \n 1. Login \n 2. Register");
            if(sc.hasNext("[1-2]")){
                return sc.nextInt();
            }
           else{
               System.out.println("Enter the valid option");
                sc.next();
           }
        }
    }

    public int getOptionFromMenu(){
        while(true){
            System.out.println("\nSelect option \n 1. Add product \n 2. Remove Product \n 3. Remove all \n 4. View Cart \n 5. Place order \n 6. My orders \n 7. Log out");
            if(sc.hasNext("[1-7]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public int selectProduct(ArrayList<Product> prodList){
        System.out.println("ID\tName\tAmount");
        for (Product product : prodList) {
            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getAmount());
        }
        while(true){
            System.out.println("Select Product using Product id");
            if(sc.hasNext("[1-5]")){
                return sc.nextInt();
            }else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public int getDeleteOption(){
        while(true){
            System.out.println("Enter product id to delete");
            if(sc.hasNext("[1-5]")){
                return sc.nextInt();
            }else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public void viewCart(Cart cart){
        System.out.println("***Cart details***\nID\tName\tAmount");
        for (int i = 0; i < cart.getCart().size(); i++) {
            System.out.println(cart.getCart().get(i).getId() + "\t" + cart.getCart().get(i).getName() + "\t" + cart.getCart().get(i).getAmount());
        }
    }

    public void displayPaymentGateway(Cart cart){
        System.out.println("\n***WELCOME TO PAYMENT GATEWAY***");
        Payment pay;
        int cvv;
        int paymentMode=this.selectPaymentMode();
        /*if(paymentMode==2){
            cardStrategy.execute(cart);
        }
        else if(paymentMode==1){
            UPIStrategy.execute(cart);
        }*/
        a.get(paymentMode).execute(cart);

    }

    private void execute(Cart cart) {

    }


    public int selectPaymentMode(){
        while(true){
            System.out.println("1. UPI Payment\n2. Credit Card Payment");
            //return sc.nextInt();
            if(sc.hasNext("[1-2]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public boolean displayOrderList(ArrayList<Order> ordList){
        System.out.println("***My Orders***");
        if(ordList.isEmpty()){
            System.out.println("No order placed :(");
            return true;
        }else{
            for (Order order : ordList) {
                System.out.println(order.toString());
                System.out.println();
            }
        }
        return false;
    }

    public void displayCancelOrder(ArrayList<Order> ordList,Order ord){
        System.out.println("Enter the Order ID:");
        int id= sc.nextInt();
        System.out.println(ord.cancelOrder(ordList,id)?"Order: "+id+" is Cancelled\nAmount:"+ord.getAmount()+" is refunded":"Order ID is not found");
    }

    public void displayRegistrationPage(){
        System.out.println("Enter Username:");
        sc.nextLine();
        String uname,pass = null,pass1;
        uname= sc.nextLine();
        boolean ok=false;
        while(!ok){
            System.out.println("Enter Password:");
            pass= sc.nextLine();
            System.out.println("Re-enter Password:");
            pass1= sc.nextLine();
            if(!pass.equals(pass1)){
                System.out.println("Password not matching!!!");
                continue;
            }
            ok=true;
        }
        Customer cus=new Customer();
        System.out.println(cus.registerNew(uname,pass)?"Successfully created":"Unable to process");
    }
}

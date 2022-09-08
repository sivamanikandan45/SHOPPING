package com.shopping;
import com.shoppingcart.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        UI ui=new UI();
        String uname , pass = null, pass1;
        Scanner sc = new Scanner(System.in);
        Customer cus ;
        Order ord = null;
        //Payment pay=null;
        ArrayList<Order> ordList = new ArrayList<>();
        ArrayList<Product> prodList=new ArrayList<Product>(){{add(new Product(1,"Product1",199));
                                                          add(new Product(2,"Product2",149));
                                                          add(new Product(3,"Product3",499));
                                                          add(new Product(4,"Product4",999));
                                                          add(new Product(5,"Product5",299));}};
        while(true){
        int option = ui.displayHome();
        if (option == 1) {
            System.out.println("Enter Username:");
            uname = sc.nextLine();
            System.out.println("Enter Password:");
            pass = sc.nextLine();
            cus = new Customer();
            if (cus.login(uname, pass)) {
                System.out.println("Login Successful");
                Cart cart = new Cart();
                boolean opt = true;
                while (opt) {
                    int choice=ui.getOptionFromMenu();
                    if (choice == 1) {
                        boolean con=true;
                        String addMore="";
                        while(con){
                            int ind=ui.selectProduct(prodList);
                            System.out.println(cart.addToCart(prodList,ind)?"Added to cart":"Unable to add");
                            while(true){
                                System.out.println("Do you want to Continue...Press Y/N");
                                addMore=sc.nextLine();
                                if(!(addMore.equalsIgnoreCase("Y")||addMore.equalsIgnoreCase("N"))){
                                    System.out.println("Enter the valid option!!!");
                                    //continue;
                                }else{break;}
                            }
                            con= addMore.equalsIgnoreCase("Y");
                        }


                    }
                    else if (choice == 2) {
                        int ind=ui.getDeleteOption();
                        if (cart.searchProduct(ind)) {
                            //prodList.get(ind).getId()
                            if (cart.removeProduct(prodList,ind)) {
                                System.out.println("Removed from cart");
                                if (cart.getCart().isEmpty()) {
                                    System.out.println("Cart is empty!!!");
                                } else {
                                    ui.viewCart(cart);
                                }
                            } else {
                                System.out.println("Unable to delete from the cart");
                            }
                        } else {
                            System.out.println("The item is not in the cart!!!");
                        }
                    }
                    else if (choice == 3) {
                        System.out.println(cart.removeAll()?"All items are removed":"The cart is empty!!!");
                    }
                    else if (choice == 4) {
                        if (cart.getCart().isEmpty()) {
                            System.out.println("Cart is empty!!!");
                        } else {
                            ui.viewCart(cart);
                        }
                        System.out.println("Total amount: " + cart.getAmount());
                    }
                    else if (choice == 5) {
                        if (cart.getCart().isEmpty()) {
                            System.out.println("Cart is empty!!!");
                        } else {
                            System.out.println("Enter your Address");
                            //sc.nextLine();
                            String add = sc.nextLine();
                            ord= new Order(uname, add);
                            ord=ord.placeOrder(cart);
                            ordList.add(ord);
                            System.out.println(ord.toString());
                            ui.displayPaymentGateway(cart);
                        }
                    }
                    else if(choice==6){
                        String cancel;
                        boolean notDisplayed=ui.displayOrderList(ordList);
                        if(notDisplayed){
                            continue;
                        }else{
                            //continue;
                            while(true){
                                System.out.println("Do you want to cancel order....? Enter Y/N:");
                                //sc.nextLine();
                                cancel=sc.nextLine();
                                if(!(cancel.equalsIgnoreCase("Y")||cancel.equalsIgnoreCase("N"))){
                                    System.out.println("Enter the valid option!!!");
                                    continue;
                                }else{break;}
                            }
                            if(cancel.equalsIgnoreCase("Y")){
                                ui.displayCancelOrder(ordList,ord);
                            }
                        }

                    }
                    else if (choice ==7) {
                        System.out.println("Logging out.....");
                        ordList.clear();
                        opt = false;
                    }
                }
            }
            else {
                System.out.println("Invalid Username or Password");
            }
        }
        else if(option==2){
           ui.displayRegistrationPage();
        }
    }
        }
    }


package com.shoppingcart;

import java.io.IOException;

public class Customer {
    Authenticator authenticator =new Authenticator();
    public boolean login(String uname,String pass){
        //allows user to log in to the system
        try{
        return authenticator.isValid(uname, pass);
        }
        catch(IOException e){
            return false;
        }
    }

    public boolean registerNew(String uname, String pass)  {
        //Registers a new user and uname and password as an array
        try{
        return authenticator.add(uname, pass);
        }
        catch(IOException obj){
            return false;
        }
    }

}

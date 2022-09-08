package com.shoppingcart;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Authenticator {

public boolean isValid(String uname,String pwd) throws IOException {
    FileReader reader=new FileReader("db.properties");
    Properties p=new Properties();
    p.load(reader);
    Set set = p.entrySet();
    Iterator itr = set.iterator();
    while (itr.hasNext()) {
        Map.Entry entry = (Map.Entry)itr.next();
        if(entry.getKey().equals(uname)&&entry.getValue().equals(pwd)){
            return true;
        }
    }
return false;
    /*for(Map.Entry<String,String> record: loginTable.entrySet()){
        if(record.getKey().equals(uname)&&record.getValue().equals(pwd)){
            return true;
        }
    }*/
   // return false;
}

public boolean add(String uname,String pass) throws IOException {
   // loginTable.put(uname,pass);
    //FileWriter writer=new FileWriter("db.properties");
    Properties p=new Properties();
    p.setProperty(uname, pass);
    FileOutputStream file = new FileOutputStream("db.properties",true);
    p.store(file, "\n");
    file.close();
    return true;
}
}

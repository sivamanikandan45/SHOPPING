package com.shoppingcart;

public class CreditCardPayment implements Payment{
    private double amount;

    @Override
    public boolean doPayment(String cardNo, int cvv, double amount) {
        //returns true if payment is successful else false
        return this.validateCard(cardNo)&&(cardNo.startsWith("4")||cardNo.startsWith("5"));
    }
    @Override
    public double calculatePayment(Cart c){
        //returns amount
        amount=c.getAmount();
        return amount;
    }
    public boolean validateCard(String cardNo){
        // it validates credit card numbers based on Luhn's Algorithm
        int sumOfEven=0;
        int sumOfOdd=Integer.parseInt(Character.toString(cardNo.charAt(cardNo.length()-1)));
        try{
            for(int i=cardNo.length()-2;i>=0;i=i-2){
                //System.out.println(cardNo.charAt(i));
                int currEven=Integer.parseInt(Character.toString(cardNo.charAt(i)));
                currEven=currEven*2;
                int x1=currEven;
                int t=0;
                while(x1>0){
                    t+=x1%10;
                    x1/=10;
                }
                sumOfEven+=t;
                sumOfOdd+=Integer.parseInt(Character.toString(cardNo.charAt(i-1)));

            }}catch(Exception e){}
        return (sumOfEven+sumOfOdd)%10==0?true:false;
    }

}

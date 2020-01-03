package com.example.mike.mortgage;

public class MortgageModel {
    private double principle;
    private int amortization;
    private double interest;

    public MortgageModel(String p,String a,String i){
        this.principle=Double.parseDouble(p);
        this.amortization=Integer.parseInt(a);
        this.interest=Double.parseDouble(i);
    }

    public String computePayment(){
        double p=this.principle;
        int n=this.amortization*12;
        double r=this.interest/1200;
        double index=(r*p)/(1-Math.pow((1+r),(-n)));
        String result=String.format("$%,.2f",index);
        return result;
    }
}

package com.corndel.supportbank.models;

// DATA MODEL and logical thoughts
// Currency
public class Currency {
    
    private double amount;
    
    public Currency(double amount){
        this.amount= amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double convertGBP(double gpbConvert) {
        return amount / 0.75;
    }

    public double convertUSD(double usdConvert) {
        return amount *0.75;
    }

    @Override
    public String toString() {
        return "Converted{" +
                ", amount=" + amount +
                '}';
    }
}





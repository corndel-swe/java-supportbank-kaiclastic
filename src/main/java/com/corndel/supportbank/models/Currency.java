package com.corndel.supportbank.models;

// DATA MODEL and logical thoughts
// Currency
public class Currency {
    
    private final double amount;

    public Currency(double amount , String currencyTo){
        this.amount= amount;
    }
    public double convertNewCurrency(double multiplier) {
        return amount * multiplier;
    }
}





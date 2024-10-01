package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import picocli.CommandLine;

@CommandLine.Command(name = "convert")
public class ConvertService implements Runnable{

    @CommandLine.Parameters(index = "0")
    private double amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;


    @Override
    public void run() {
        Currency currency = new Currency(amount);
        if (from.equals("USD")){
            System.out.println("The converted currency is " + currency.convertUSD(100));
        } else{
            System.out.println("The converted currency is " + currency.convertGBP(100));
        }
        System.out.println("this is the currency"+currency);
    }

}

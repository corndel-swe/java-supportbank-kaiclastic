package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import picocli.CommandLine;

@CommandLine.Command(name = "convert")
public class ConvertService implements Runnable {

    @CommandLine.Parameters(index = "0")
    private double amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;


    @Override
    public void run() {
        Currency currency = new Currency(amount,to);
        CurrencyAPI currencyAPI = new CurrencyAPI();
        try {
            CurrencyAPI.Rates allRates = currencyAPI.getRates();
            System.out.println( "retrieved Rates" +allRates.rates);
            if(from.equals("USD")){
                Double conversionRate = allRates.rates.get(to);
                System.out.println(conversionRate);
               double newBalance =  currency.convertNewCurrency(conversionRate);
                System.out.printf("%.2f %s is converted to %.2f %s%n ", amount, from, newBalance, to);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}

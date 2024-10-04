package com.corndel.supportbank.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAPI {

    private final Dotenv dotenv = Dotenv.load();
    private final String appId = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");
    private final String baseUrl = "https://openexchangerates.org/api/latest.json?app_id=" + appId;

    public class Rates {
        // create a hashmap
        public Map<String, Double> rates;
// use hashmap in the constructor
        public Rates(Map<String, Double> rates) {
            this.rates = rates;
        }
    }

    // create a method that is an instance of the Rates
    // make a request and retrieve it as json string
    public Rates getRates() throws JsonProcessingException {
        HttpResponse<String> response = Unirest
                .get(baseUrl)
                .header("Accept", "application/json")
                .asString();
        // instance of jackson
        ObjectMapper mapper = new ObjectMapper();
        // deserialse ie target specific object of json body and return it as hashmap in results
        Map<String, Object> result = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {});
        Map<String, Double> rates = (Map<String, Double>) result.get("rates");
        System.out.println(rates);


        return new Rates(rates);
    }

    public static void main(String[] args) {
        try {
            CurrencyAPI currencyAPI = new CurrencyAPI();
            Rates allrates = currencyAPI.getRates();
            System.out.println(allrates + "in the try");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

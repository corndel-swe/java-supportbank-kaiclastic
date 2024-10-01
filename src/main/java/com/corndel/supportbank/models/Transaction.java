package com.corndel.supportbank.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Transaction {

    private String fileName;
    public Transaction(String fileName){
        this.fileName= fileName;
    }

    public  List<String> readFile(String fileName) throws IOException {
        Path filePath = Paths.get("src", "data", "transactions",fileName);
        List<String> lines = Files.readAllLines(filePath);
        return lines;
    }

    public  List<String> filteredCVS() throws IOException {
        List<String> originalFile= readFile(fileName);
        System.out.println(originalFile);

        Map<String, Double> accounts = new HashMap<>();


        for (int i = 1; i<originalFile.size();i++){
            String[] each = originalFile.get(i).split(",");
            System.out.println(Arrays.toString(each));
            String name = each[1];
            String amount = each[4];
            double oldBalance = accounts.getOrDefault(name, 0.0);
            double newBalance = oldBalance + Double.parseDouble(amount);
            accounts.put(name, newBalance);
        }
        System.out.println(accounts);








        return originalFile;
    }
}



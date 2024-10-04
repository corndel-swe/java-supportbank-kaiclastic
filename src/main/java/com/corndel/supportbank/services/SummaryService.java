package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "summary")
public class SummaryService implements Runnable {

    @CommandLine.Parameters(index = "0")
    private String fileName;


    @Override
    public void run() {
        Transaction transaction = new Transaction(fileName);
        try {
            transaction.filteredCVS();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

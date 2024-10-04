package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(name = "list")
public class ListService {
    @CommandLine.Parameters(index = "0")
    private String fileName;

    @CommandLine.Parameters(index = "1")
    private String accountName;


}

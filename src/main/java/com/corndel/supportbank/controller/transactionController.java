package com.corndel.supportbank.controller;
import com.corndel.supportbank.services.ListService;
import com.corndel.supportbank.services.SummaryService;
import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {SummaryService.class, ListService.class})
public class transactionController {

}

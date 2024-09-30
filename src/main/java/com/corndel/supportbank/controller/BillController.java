package com.corndel.supportbank.controller;


import com.corndel.supportbank.services.BillService;
import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = {BillService.class})
public class BillController {

}

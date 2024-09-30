package com.corndel.supportbank.controller;

import com.corndel.supportbank.services.ConvertService;
import picocli.CommandLine.Command;
@Command(name = "currency", subcommands = {ConvertService.class})
public class ConvertController {

}

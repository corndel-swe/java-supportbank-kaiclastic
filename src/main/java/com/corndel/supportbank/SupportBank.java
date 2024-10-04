package com.corndel.supportbank;

import com.corndel.supportbank.controller.BillController;
import com.corndel.supportbank.controller.ConvertController;
import com.corndel.supportbank.controller.transactionController;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine;

import java.util.Arrays;

@CommandLine.Command(name = "supportbank", subcommands = {BillController.class, ConvertController.class, transactionController.class})
public class SupportBank implements Runnable {

  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new SupportBank());
    System.out.println(Arrays.toString(args));
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
  }
  @Override
  public void run() {
    System.out.println(Chalk.on("Welcome to the support bank!").green());
  }
}

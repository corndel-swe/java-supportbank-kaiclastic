package com.corndel.supportbank.exercises;

// import java.nio.file.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//src/data/nums.txt

public class Adder {

  /**
   * This method reads a file line by line and adds up the numbers on each line.
   * It uses try/catch to print "Something went wrong" and
   * returns 0 in case of an exception.
   *
   * @param fileName The name of the file to be read.
   * @return The sum of the numbers in the file.
   */

  public int add(String fileName) {
    // TODO: Read the file
    // Hint: Use Paths.get() and Files.readAllLines()
    // TODO: Add up the numbers
    // Hint: Use a loop
    // Hint: Use Integer.parseInt
    // return the sum
    // TODO: Return the sum

    try {
      int sum = 0;
      Path filePath = Paths.get("src", "data", fileName);
      List<String> lines = Files.readAllLines(filePath);
      for(String line:lines){
        sum += Integer.parseInt(line);
      }
        return sum;
    }

    // catching errors
    catch(Exception e ) {
      System.err.println("Something went wrong");
      return 0;
    }
  }

  /**
   * Calls the add method and prints the result.
   * This method is for debugging purposes only.
   */
  public static void main(String[] args) {
    Adder adder = new Adder();
    System.out.println(adder.add("nums.txt"));
  }
}

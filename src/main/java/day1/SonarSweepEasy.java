package day1;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@EasyTask
@RunnableTask
public class SonarSweepEasy {

  public static void result() throws Exception {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day1/input.txt");

    int previous = 0;
    int higherValues = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = reader.readLine()) != null) {
        int current = Integer.parseInt(line);

        if (previous == 0) {
          previous = current;
          continue;
        }

        if (previous < current) {
          higherValues++;
        }

        previous = current;
      }
      System.out.println("Higher values: " + higherValues);

      long end = System.currentTimeMillis();

      System.out.println("\nTime spent: " + (end - start) + "ms");
    }
  }
}
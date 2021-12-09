package day1;

import util.DifficultTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@DifficultTask
@RunnableTask
public class SonarSweepDifficult {

  public static void result() throws Exception {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day1/input.txt");

    int startIndex = 0;
    int endIndex = 2;

    int previous = 0;
    int higherValues = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      List<Integer> intList = new ArrayList<>();

      while ((line = reader.readLine()) != null) {
        intList.add(Integer.parseInt(line));
      }

      while (endIndex < intList.size()) {
        int current = 0;

        for (int i = startIndex; i <= endIndex; i++) {
          current += intList.get(i);
        }

        if (previous == 0) {
          previous = current;
          continue;
        }

        if (previous < current) {
          higherValues++;
        }

        previous = current;
        startIndex++;
        endIndex++;
      }

      System.out.println("Higher values: " + higherValues);

      long end = System.currentTimeMillis();

      System.out.println("\nTime spent: " + (end - start) + "ms");
    }
  }

}
package day7;

import util.DifficultTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

@DifficultTask
@RunnableTask
public class TheTreacheryOfWhalesDifficult {
  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day7/input.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      ArrayList<Integer> crabs = new ArrayList<>(Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).boxed().toList());
      Collections.sort(crabs);
      int fuelCost = 0;

      Integer mean = (crabs.stream().reduce(0, Integer::sum)) / crabs.size();
      for (Integer c : crabs) {
        int n = Math.abs(c - mean);
        fuelCost += (((n * n) + n) / 2);
      }

      System.out.println("Fuel needed to align to position: " + fuelCost);
    }

    long end = System.currentTimeMillis();
    System.out.println("\nTime spent: " + (end - start) + "ms");
  }
}

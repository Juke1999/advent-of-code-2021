package day7;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

@EasyTask
@RunnableTask
public class TheTreacheryOfWhalesEasy {
  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day7/input.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      ArrayList<Integer> crabs = new ArrayList<>(Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).boxed().toList());
      Collections.sort(crabs);
      int fuelCost = 0;

      Integer median = crabs.get(crabs.size() / 2);
      for (Integer c : crabs) {
        fuelCost += Math.abs(c - median);
      }

      System.out.println("Most optimal fuel cost: " + fuelCost);
    }

    long end = System.currentTimeMillis();
    System.out.println("\nTime spent: " + (end - start) + "ms");
  }
}

package day6;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

@EasyTask
@RunnableTask
public class LanternfishEasy {
  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day6/input.txt");

    long[] lanternfish = new long[10];

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      for (String s : reader.readLine().split(",")) {
        lanternfish[Integer.parseInt(s)]++;
      }
      for (int day = 0; day < 80; day++) {
        lanternfish[7] += lanternfish[0];
        lanternfish[9] = lanternfish[0];
        IntStream.range(0, 9).forEach(i -> lanternfish[i] = lanternfish[i + 1]);
        lanternfish[9] = 0;
      }
    }

    System.out.println("Lanternfish after 80 days: " + Arrays.stream(lanternfish).sum());

    long end = System.currentTimeMillis();
    System.out.println("\nTime spent: " + (end - start) + "ms");
  }
}

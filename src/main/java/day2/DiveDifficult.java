package day2;

import day1.SonarSweepEasy;
import util.DifficultTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@DifficultTask
@RunnableTask
public class DiveDifficult {

  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    InputStream inputStream = SonarSweepEasy.class.getClassLoader().getResourceAsStream("day2/input.txt");

    int depth = 0;
    int horizontal = 0;
    int aim = 0;

    if (inputStream != null) {
      try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;

        while ((line = br.readLine()) != null) {
          String[] lineParts = line.split(" ");

          switch (lineParts[0]) {
            case ("forward") -> {
              horizontal += Integer.parseInt(lineParts[1]);
              depth += (aim * Integer.parseInt(lineParts[1]));
            }
            case ("down") -> aim += Integer.parseInt(lineParts[1]);
            case ("up") -> aim -= Integer.parseInt(lineParts[1]);
          }
        }

        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        System.out.println("Calculation: " + (horizontal * depth));

        long end = System.currentTimeMillis();

        System.out.println("\nTime spent: " + (end - start) + "ms");
      }
    }
  }
}
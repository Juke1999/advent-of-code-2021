package day2;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@EasyTask
@RunnableTask
public class DiveEasy {

  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day2/input.txt");

    int depth = 0;
    int horizontal = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] lineParts = line.split(" ");

        switch (lineParts[0]) {
          case ("forward") -> horizontal += Integer.parseInt(lineParts[1]);
          case ("down") -> depth += Integer.parseInt(lineParts[1]);
          case ("up") -> depth -= Integer.parseInt(lineParts[1]);
        }
      }

      System.out.println("Depth: " + depth);
      System.out.println("Horizontal: " + horizontal);
      System.out.println("Multiplication: " + (depth * horizontal));

      long end = System.currentTimeMillis();

      System.out.println("\nTime spent: " + (end - start) + "ms");
    }
  }

}

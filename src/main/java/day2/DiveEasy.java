package day2;

import day1.SonarSweepEasy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import util.EasyTask;

@EasyTask
public class DiveEasy {

  public static void result() throws IOException {
    InputStream inputStream = SonarSweepEasy.class.getClassLoader()
        .getResourceAsStream("day2/input.txt");

    int depth = 0;
    int horizontal = 0;

    if (inputStream != null) {
      try (BufferedReader br
          = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;

        while ((line = br.readLine()) != null) {
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

      }
    }
  }

}

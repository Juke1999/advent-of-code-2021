package dayone;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SonarSweep {

  public static void partOne() throws Exception {
    InputStream inputStream = SonarSweep.class.getClassLoader()
        .getResourceAsStream("dayone/input.txt");

    int previous = 0;
    int higherValues = 0;

    try (BufferedReader br
        = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;

      while ((line = br.readLine()) != null) {
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
      System.out.println(higherValues);
    }
  }

  public static void partTwo() throws Exception {
    InputStream inputStream = SonarSweep.class.getClassLoader()
        .getResourceAsStream("dayone/input.txt");

    int startIndex = 0;
    int endIndex = 2;

    int previous = 0;
    int higherValues = 0;

    try (BufferedReader br
        = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      List<Integer> intList = new ArrayList<>();

      while ((line = br.readLine()) != null) {
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

      System.out.println(higherValues);
    }

  }

}
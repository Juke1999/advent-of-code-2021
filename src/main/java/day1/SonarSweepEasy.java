package dayone;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import util.DifficultTask;
import util.EasyTask;

@EasyTask
public class SonarSweepEasy {

  public static void result() throws Exception {
    InputStream inputStream = SonarSweepEasy.class.getClassLoader()
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
}
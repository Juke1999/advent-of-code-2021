package day3;

import day1.SonarSweepEasy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import util.DifficultTask;

@DifficultTask
public class BinaryDiagnosticDifficult {

  public static void result() throws IOException {
    InputStream inputStream = SonarSweepEasy.class.getClassLoader()
        .getResourceAsStream("day3/input.txt");

    try (BufferedReader br
        = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;

      while ((line = br.readLine()) != null) {

      }
    }
  }

}

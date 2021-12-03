package day3;

import day1.SonarSweepEasy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import util.EasyTask;

@EasyTask
public class BinaryDiagnosticEasy {

  public static void result() throws IOException {
    int currentIndex = 0;
    int maxIndex = 1;
    StringBuilder gammaRate = new StringBuilder();

    while (currentIndex < maxIndex) {

      InputStream inputStream = SonarSweepEasy.class.getClassLoader()
          .getResourceAsStream("day3/input.txt");

      try (BufferedReader br
          = new BufferedReader(new InputStreamReader(inputStream))) {

        String line;
        StringBuilder gammaRateLoop = new StringBuilder();

        while ((line = br.readLine()) != null) {
          maxIndex = line.length();
          gammaRateLoop.append(line.toCharArray()[currentIndex]);
        }

        gammaRate.append(gammaRateLoop.chars()
            .mapToObj(x -> (char) x)
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
            .entrySet().stream()
            .max(Entry.comparingByValue())
            .get()
            .getKey());

        gammaRateLoop.delete(0, gammaRateLoop.length());
        currentIndex++;
      }
    }

    int gammaRateDecimal = Integer.parseInt(gammaRate.toString(), 2);
    int epsilonRateDecimal = Integer.parseInt(swapBinary(String.valueOf(gammaRate)), 2);

    System.out.println("Gamma Rate: " + gammaRate + " --> " + gammaRateDecimal);
    System.out.println(
        "Epsilon Rate: " + swapBinary(gammaRate.toString()) + " --> " + epsilonRateDecimal);
    System.out.println("Fuel Usage: " + gammaRateDecimal * epsilonRateDecimal);
  }

  private static String swapBinary(String binaryString) {
    return binaryString.replace("0", "-")
        .replace("1", "x")
        .replace("-", "1")
        .replace("x", "0");
  }

}
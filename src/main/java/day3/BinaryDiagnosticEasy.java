package day3;

import day1.SonarSweepEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import util.EasyTask;

@EasyTask
public class BinaryDiagnosticEasy {

  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    int currentIndex = 0;
    int maxIndex = 1;

    StringBuilder gammaRate = new StringBuilder();
    List<String> values = new ArrayList<>();

    InputStream inputStream = SonarSweepEasy.class.getClassLoader().getResourceAsStream("day3/input.txt");

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

      String line;

      while ((line = br.readLine()) != null) {
        maxIndex = line.length();
        values.add(line);
      }

      while (currentIndex < maxIndex) {
        StringBuilder gammaRateLoop = new StringBuilder();

        for (String s : values) {
          gammaRateLoop.append(s.charAt(currentIndex));
        }

        gammaRate.append(getMostBit(gammaRateLoop.toString()));
        currentIndex++;
      }
    }

    int gammaRateDecimal = Integer.parseInt(gammaRate.toString(), 2);
    int epsilonRateDecimal = Integer.parseInt(swapBinary(String.valueOf(gammaRate)), 2);

    System.out.println("Gamma Rate: " + gammaRate + " --> " + gammaRateDecimal);
    System.out.println("Epsilon Rate: " + swapBinary(gammaRate.toString()) + " --> " + epsilonRateDecimal);
    System.out.println("Fuel Usage: " + gammaRateDecimal * epsilonRateDecimal);

    long finish = System.currentTimeMillis();

    System.out.println("\nTime spent: " + (finish - start) + "ms");
  }

  private static char getMostBit(String stringBits) {
    int zeroes = 0;
    int ones = 0;

    for (char c : stringBits.toCharArray()) {
      int i = c == '0' ? zeroes++ : ones++;
    }

    if (zeroes > ones) {
      return '0';
    }
    return '1';

  }

  private static String swapBinary(String binaryString) {
    return binaryString.replace("0", "-")
            .replace("1", "x")
            .replace("-", "1")
            .replace("x", "0");
  }

}
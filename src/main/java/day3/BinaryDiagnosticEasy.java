package day3;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@EasyTask
@RunnableTask
public class BinaryDiagnosticEasy {

  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    int currentIndex = 0;
    int maxIndex = 1;

    StringBuilder gammaRate = new StringBuilder();
    List<String> values = new ArrayList<>();

    File file = new File("src/main/resources/day3/input.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

      String line;

      while ((line = reader.readLine()) != null) {
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

    long end = System.currentTimeMillis();

    System.out.println("\nTime spent: " + (end - start) + "ms");
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
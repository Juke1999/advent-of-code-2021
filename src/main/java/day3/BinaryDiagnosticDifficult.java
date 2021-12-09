package day3;

import day1.SonarSweepEasy;
import util.DifficultTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DifficultTask
@RunnableTask
public class BinaryDiagnosticDifficult {

  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    int currentIndex = 0;
    int maxIndex = 1;

    int oxygenGeneratorRating;
    int co2ScrubberRating = 0;

    List<String> values = new ArrayList<>();
    List<String> oxygen;
    List<String> co2Scrubber;

    InputStream inputStream = SonarSweepEasy.class.getClassLoader().getResourceAsStream("day3/input.txt");

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

      String line;

      while ((line = br.readLine()) != null) {
        maxIndex = line.length();
        values.add(line);
      }

      oxygen = values;
      co2Scrubber = values;

      while (currentIndex < maxIndex || (oxygen.size() != 1 && co2Scrubber.size() != 1)) {
        StringBuilder currentBitsOxygen = new StringBuilder();
        StringBuilder currentBitsCO2Scrubber = new StringBuilder();

        for (String s : oxygen) {
          currentBitsOxygen.append(s.charAt(currentIndex));
        }

        for (String s : co2Scrubber) {
          currentBitsCO2Scrubber.append(s.charAt(currentIndex));
        }

        char mostCommonBit = getMostBit(currentBitsOxygen.toString());
        char leastCommonBit = getLeastBit(currentBitsCO2Scrubber.toString());

        int finalCurrentIndex = currentIndex;

        if (oxygen.size() != 1) {
          oxygen = oxygen.stream()
                  .filter(s -> s.charAt(finalCurrentIndex) == mostCommonBit)
                  .collect(Collectors.toList());
        }

        if (co2Scrubber.size() != 1) {
          co2Scrubber = co2Scrubber.stream()
                  .filter(s -> s.charAt(finalCurrentIndex) == leastCommonBit)
                  .collect(Collectors.toList());
        }

        currentIndex++;
      }

      oxygenGeneratorRating = Integer.parseInt(oxygen.get(0), 2);
      co2ScrubberRating = Integer.parseInt(co2Scrubber.get(0), 2);
    }

    System.out.println("Oxygen Generator Rating: " + oxygen.get(0) + " --> " + oxygenGeneratorRating);
    System.out.println("CO2 Scrubber Rating: " + co2Scrubber.get(0) + " --> " + co2ScrubberRating);
    System.out.println("Life Support Rating: " + (oxygenGeneratorRating * co2ScrubberRating));

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

  private static char getLeastBit(String stringBits) {
    int zeroes = 0;
    int ones = 0;

    for (char c : stringBits.toCharArray()) {
      int i = c == '0' ? zeroes++ : ones++;
    }

    if (ones < zeroes) {
      return '1';
    }
    return '0';

  }

}
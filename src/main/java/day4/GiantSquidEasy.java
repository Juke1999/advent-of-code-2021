package day4;

import day1.SonarSweepEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GiantSquidEasy {
  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    InputStream inputStream = SonarSweepEasy.class.getClassLoader().getResourceAsStream("day4/input.txt");

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

      String line;

      Stack<Integer> bingoNumbers = new Stack<>();

      while ((line = br.readLine()) != null) {

        if (line.equals("")) {
          continue;
        }

        if (line.contains(",")) {
          for (String s : line.split(",")) {
            bingoNumbers.push(Integer.parseInt(s));
          }
        } else {
          line = line.stripIndent();

          int i = 0;

          for(String s : line.split("(\s+)")) {
              System.out.print(s + " - "); // Prints one row from one bingo board
          }
          System.out.println();
        }

      }

    }
  }

  private boolean isRowSolved(char[][] gameBoard) {
    List<List<Character>> charList = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      List<Character> characters = new ArrayList<>();
      for (int j = 0; j < 5; j++) {
        characters.add(gameBoard[j][i]);
      }
      charList.add(characters);
    }

    return checkForSolved(charList);
  }

  private boolean isColumnSolved(char[][] gameBoard) {
    List<List<Character>> charList = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      List<Character> characters = new ArrayList<>();
      for (int j = 0; j < 5; j++) {
        characters.add(gameBoard[i][j]);
      }
      charList.add(characters);
    }

    return checkForSolved(charList);
  }

  private boolean checkForSolved(List<List<Character>> charList) {
    int sameSymbols = 5;
    char previous = ' ';
    int countedValue = 1;
    boolean solved = false;

    charList = charList.stream()
            .filter(characters -> characters.size() >= 5)
            .collect(Collectors.toList());

    for (List<Character> list : charList) {
      for (char character : list) {
        if (previous != ' ' && previous == character) {
          countedValue++;
        } else {
          countedValue = 1;
        }

        previous = character;
        solved |= (countedValue == sameSymbols);
      }
    }

    return solved;
  }

}

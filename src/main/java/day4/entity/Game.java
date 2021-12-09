package day4.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Game {
  public ArrayList<Board> boards = new ArrayList<>();
  public int[] draws;

  public Game(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      draws = Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
      String line;
      ArrayList<Integer> fill = new ArrayList<>();
      while ((line = reader.readLine()) != null) {
        if (line.trim().length() == 0) {
          if (fill.size() == 25) boards.add(new Board(fill.stream().mapToInt(i -> i).toArray()));
          fill.clear();
        } else {
          String[] segments = line.trim().split(" ");
          for (String segment : segments) {
            try {
              fill.add(Integer.parseInt(segment));
            } catch (Exception ignored) {
            }
          }
        }
      }
    } catch (IOException ignored) {
    }
  }
}

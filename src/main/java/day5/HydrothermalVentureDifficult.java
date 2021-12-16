package day5;

import util.DifficultTask;
import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DifficultTask
@RunnableTask
public class HydrothermalVentureDifficult {
  public static void result() throws IOException {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day5/input.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;

      int[][] map = new int[1000][1000];
      int dangerZones = 0;

      while ((line = reader.readLine()) != null) {
        Matcher match = Pattern.compile("(\\d*),(\\d*) -> (\\d*),(\\d*)").matcher(line);
        if (match.find()) {
          int[] coord = new int[]{
                  Integer.parseInt(match.group(1)),
                  Integer.parseInt(match.group(2)),
                  Integer.parseInt(match.group(3)),
                  Integer.parseInt(match.group(4))};

          if (coord[0] == coord[2] && coord[1] != coord[3]) {
            if (++map[coord[0]][coord[1]] == 2) {
              dangerZones++;
            }
            int inc = coord[1] > coord[3] ? -1 : +1;
            while (coord[1] != coord[3]) {
              coord[1] += inc;
              if (++map[coord[0]][coord[1]] == 2) {
                dangerZones++;
              }
            }
          } else if (coord[0] != coord[2] && coord[1] == coord[3]) {
            if (++map[coord[0]][coord[1]] == 2) {
              dangerZones++;
            }
            int inc = coord[0] > coord[2] ? -1 : +1;
            while (coord[0] != coord[2]) {
              coord[0] += inc;
              if (++map[coord[0]][coord[1]] == 2) {
                dangerZones++;
              }
            }
          } else {
            if (++map[coord[0]][coord[1]] == 2) {
              dangerZones++;
            }
            int[] incs = new int[] {coord[0] > coord[2] ? -1 : + 1, coord[1] > coord[3] ? -1 : + 1};
            while (coord[0] != coord[2])
            {
              coord[0] += incs[0];
              coord[1] += incs[1];
              if (++map[coord[0]][coord[1]] == 2) {
                dangerZones++;
              }
            }
          }
        }
      }

      System.out.println("Overlapping pipes: " + dangerZones);

      long end = System.currentTimeMillis();
      System.out.println("\nTime spent: " + (end - start) + "ms");
    }
  }
}
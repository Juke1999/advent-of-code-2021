package day5;

import util.EasyTask;
import util.RunnableTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@EasyTask
@RunnableTask
public class HydrothermalVentureEasy {
  private static void result() throws IOException {
    File file = new File("src/main/resources/day5/input.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = reader.readLine()) != null) {

      }
    }
  }
}

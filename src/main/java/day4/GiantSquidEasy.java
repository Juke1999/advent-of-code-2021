package day4;

import day4.entity.Board;
import day4.entity.Game;
import util.EasyTask;
import util.RunnableTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@EasyTask
@RunnableTask
public class GiantSquidEasy {
  public static void result() {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day4/input.txt");

    System.out.println("Winner board: " + getWinner(file).getScore());

    long end = System.currentTimeMillis();
    System.out.println("\nTime spent: " + (end - start) + "ms");

  }

  public static Board getWinner(File file) {
    Game game = new Game(file);
    ArrayList<Integer> states = new ArrayList<>();
    for (Board board : game.boards) {
      states.add(board.winsAt(game.draws));
    }
    return game.boards.get(states.indexOf(Collections.min(states)));
  }
}
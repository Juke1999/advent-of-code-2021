package day4;

import day4.entity.Board;
import day4.entity.Game;
import util.DifficultTask;
import util.RunnableTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

@DifficultTask
@RunnableTask
public class GiantSquidDifficult {

  public static void result() {
    long start = System.currentTimeMillis();

    File file = new File("src/main/resources/day4/input.txt");

    System.out.println("The last winning board: " + getLastWinning(file).getScore());

    long end = System.currentTimeMillis();
    System.out.println("\nTime spent: " + (end - start) + "ms");

  }

  public static Board getLastWinning(File file) {
    Game game = new Game(file);
    ArrayList<Integer> states = new ArrayList<>();
    for (Board board : game.boards) {
      states.add(board.winsAt(game.draws));
    }
    return game.boards.get(states.indexOf(Collections.max(states)));
  }
}

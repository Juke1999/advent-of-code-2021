package day4.entity;

import java.util.HashMap;

public class Board {
  State state = State.unsolved;
  int stateCode = 0;
  int winsOnValue = 0;
  Boolean[] data;
  HashMap<Integer, Integer> indexOf = new HashMap<>();

  public Board(int[] data) {
    this.data = new Boolean[data.length];
    for (int i = 0; i < data.length; i++) indexOf.put(data[i], i);
  }

  public int winsAt(int[] draws) {
    for (int i = 0; i < draws.length; i++) {
      try {
        int idx = indexOf.get(draws[i]);
        data[idx] = true;
        if ((state = checkWin(idx)) != State.unsolved) {
          stateCode = (i * 1000) + (idx + (state == State.columnWin ? 25 : 0));
          winsOnValue = draws[i];
          return stateCode;
        }
      } catch (Exception ignored) {
      }
    }
    return 0;
  }

  public State checkWin(int at) {
    int c = 0;
    int row = at - (at % 5);
    try {
      while (c != 5 && data[row++]) {
        c++;
      }
    } catch (Exception ignored) {
    }
    if (c == 5) return State.rowWin;
    c = 0;
    int col = at % 5;
    while (c != 5 && data[col]) {
      col += 5;
      c++;
    }
    return (c == 5) ? State.columnWin : State.unsolved;
  }

  public int getScore() {
    if (state == State.unsolved) return 0;
    int score = 0;
    for (int key : indexOf.keySet()) {
      if (data[indexOf.get(key)] == null) {
        score += key;
      }
    }
    return score * winsOnValue;
  }

  @Override
  public String toString() {
    return indexOf.toString();
  }

  enum State {
    unsolved, rowWin, columnWin
  }
}

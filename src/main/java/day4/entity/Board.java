package day4.entity;

import java.util.HashMap;

public class Board {
  State state = State.UNSOLVED;
  int stateCode = 0;
  int winsOnValue = 0;
  Boolean[] winnerData;
  HashMap<Integer, Integer> bingoBoardIndices = new HashMap<>();

  public Board(int[] data) {
    this.winnerData = new Boolean[data.length];
    for (int i = 0; i < data.length; i++) bingoBoardIndices.put(data[i], i);
  }

  public int winsAt(int[] draws) {
    for (int i = 0; i < draws.length; i++) {
      try {
        int idx = bingoBoardIndices.get(draws[i]);
        winnerData[idx] = true;
        if ((state = checkWin(idx)) != State.UNSOLVED) {
          stateCode = (i * 1000) + (idx + (state == State.COLUMN_WIN ? 25 : 0));
          winsOnValue = draws[i];
          return stateCode;
        }
      } catch (Exception ignored) {
      }
    }
    return 0;
  }

  public State checkWin(int at) {
    int checkedNumbersInARow = 0;
    int currentRow = at - (at % 5);
    try {
      while (checkedNumbersInARow != 5 && winnerData[currentRow++]) {
        checkedNumbersInARow++;
      }
    } catch (Exception ignored) {
    }
    if (checkedNumbersInARow == 5) return State.ROW_WIN;
    checkedNumbersInARow = 0;
    int currentColumn = at % 5;
    while (checkedNumbersInARow != 5 && winnerData[currentColumn]) {
      currentColumn += 5;
      checkedNumbersInARow++;
    }
    return (checkedNumbersInARow == 5) ? State.COLUMN_WIN : State.UNSOLVED;
  }

  public int getScore() {
    if (state == State.UNSOLVED) return 0;
    int score = 0;
    for (int key : bingoBoardIndices.keySet()) {
      if (winnerData[bingoBoardIndices.get(key)] == null) {
        score += key;
      }
    }
    return score * winsOnValue;
  }

  @Override
  public String toString() {
    return bingoBoardIndices.toString();
  }

  enum State {
    UNSOLVED, ROW_WIN, COLUMN_WIN
  }
}

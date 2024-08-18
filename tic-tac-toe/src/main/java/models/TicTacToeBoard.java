package models;

import java.util.UUID;

public class TicTacToeBoard extends Board {

  private int row;
  private int column;
  private int playersAllowed;
  private char[][] grid;

  public TicTacToeBoard(int row, int column, int playersAllowed, String id) {
    super(id);
    this.row = row;
    this.column = column;
    this.playersAllowed = playersAllowed;
    this.grid = new char[row][column];


    // Set default value as '_'
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        grid[i][j] = '_';
      }
    }
  }

  public void setGridValue(int row, int column, char value) {
    this.grid[row][column] = value;
  }

  public char[][] getGrid() {
    return grid;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public int getPlayersAllowed() {
    return playersAllowed;
  }

  public void setPlayersAllowed(int playersAllowed) {
    this.playersAllowed = playersAllowed;
  }
}

package models;

import java.util.UUID;

public class TicTacToeMove extends Move{

  private int row;
  private int col;
  private String playerId;

  public TicTacToeMove(int row, int col, String playerId) {
    super(UUID.randomUUID().toString());
    this.row = row;
    this.col = col;
    this.playerId = playerId;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }
}

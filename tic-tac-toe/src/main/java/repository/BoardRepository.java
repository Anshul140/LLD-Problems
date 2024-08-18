package repository;

import java.util.HashMap;
import java.util.Map;
import models.Board;

public class BoardRepository {
  private Map<String, Board> boards = new HashMap<>();

  public Board getBoard(String boardId) {
    return boards.get(boardId);
  }

  public void add(Board board) {
    boards.put(board.getId(), board);
  }

  public void update(Board board) {
    boards.put(board.getId(), board);
  }
}

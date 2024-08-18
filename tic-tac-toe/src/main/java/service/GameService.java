package service;

import models.Move;

public interface GameService {

  boolean move(Move move, String boardId) throws Exception;

  void displayBoard(String boardId) throws Exception;
}

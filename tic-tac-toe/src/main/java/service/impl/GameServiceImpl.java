package service.impl;

import models.Board;
import models.Move;
import models.Player;
import models.TicTacToeBoard;
import models.TicTacToeMove;
import repository.BoardRepository;
import repository.PlayerRepository;
import service.GameService;

public class GameServiceImpl implements GameService {

  private final BoardRepository boardRepository;
  private final PlayerRepository playerRepository;

  public GameServiceImpl(BoardRepository boardRepository, PlayerRepository playerRepository) {
    this.boardRepository = boardRepository;
    this.playerRepository = playerRepository;
  }

  private boolean isWinningMove(TicTacToeMove move, char sign, String boardId) {
    boolean rowCheck = true;
    boolean colCheck = true;
    boolean diagCheck = true;
    boolean antiDiagCheck = true;

    int row = move.getRow();
    int col = move.getCol();
    TicTacToeBoard board = (TicTacToeBoard) boardRepository.getBoard(boardId);
    char[][] grid = board.getGrid();

    // row check
    for(int i = 0; i<3; i++) {
      if(grid[row][i] != sign) {
        rowCheck = false;
        break;
      }
    }

    // column check
    for(int i = 0; i<3; i++) {
      if(grid[i][col] != sign) {
        colCheck = false;
        break;
      }
    }

    // diagonal check
    for(int i = 0; i<3; i++) {
      if(grid[i][i] != sign) {
        diagCheck = false;
        break;
      }
    }

    // anti diagonal check
    for(int i = 0; i<3; i++) {
      if(grid[i][3-i-1] != sign){
        antiDiagCheck = false;
        break;
      }
    }

    return rowCheck || colCheck || diagCheck || antiDiagCheck;
  }

  @Override
  public boolean move(Move move, String boardId) throws Exception {
    Board board = boardRepository.getBoard(boardId);
    TicTacToeMove ticTacToeMove = (TicTacToeMove) move;

    TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
    Player player = playerRepository.get(ticTacToeMove.getPlayerId());

    char[][] grid = ticTacToeBoard.getGrid();
    int x = ticTacToeMove.getRow(), y = ticTacToeMove.getCol();
    if(grid[x][y] != '_') {
      throw new Exception("Invalid move");
    }
    ticTacToeBoard.setGridValue(ticTacToeMove.getRow(), ticTacToeMove.getCol(), player.getSign());
    boardRepository.update(ticTacToeBoard);

    return isWinningMove(ticTacToeMove, player.getSign(), boardId);
  }

  @Override
  public void displayBoard(String boardId) throws Exception {
    Board board = boardRepository.getBoard(boardId);
    TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;

    char[][] grid = ticTacToeBoard.getGrid();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println("     ");
    }
  }
}

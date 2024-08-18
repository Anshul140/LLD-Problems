import java.util.Scanner;
import models.Move;
import models.Player;
import models.TicTacToeBoard;
import models.TicTacToeMove;
import repository.BoardRepository;
import repository.PlayerRepository;
import service.GameService;
import service.PlayerService;
import service.impl.GameServiceImpl;
import service.impl.PlayerServiceImpl;

public class GameEngine {
  private static BoardRepository boardRepository= new BoardRepository();
  private static PlayerRepository playerRepository= new PlayerRepository();

  private static GameService gameService = new GameServiceImpl(boardRepository, playerRepository);
  private static PlayerService playerService = new PlayerServiceImpl(playerRepository);

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // construct static board
    TicTacToeBoard board = new TicTacToeBoard(3, 3, 2, "b1");
    boardRepository.add(board);

    // take 1st player input
    String line1 = scanner.nextLine();
    String[] tokens1 = line1.split(" ");
    char s1 = tokens1[0].charAt(0);
    String p1 = tokens1[1];
    // construct player 1 and save
    Player player1 = new Player(p1, s1, "p1");
    playerService.addPlayer(player1);

    // take 2nd player input
    String line2 = scanner.nextLine();
    String[] tokens2 = line2.split(" ");
    char s2 = tokens2[0].charAt(0);
    String p2 = tokens2[1];
    // construct player 2 and save
    Player player2 = new Player(p2, s2, "p2");
    playerService.addPlayer(player2);


    int ctr = 0;

    boolean running = true;
    while (running) {
      if(ctr == 9) {
        // end the game
        System.out.println("Game Over!");
      }

      String line = scanner.nextLine();
      String[] tokens3 = line.split(" ");

      if(tokens3[0].equals("exit")) {
        running = false;
        break;
      }
      int row = Integer.parseInt(tokens3[0]);
      int col = Integer.parseInt(tokens3[1]);

      // reducing values by 1 to handle 0 based indexing
      row--;
      col--;

      if(!isValidCell(row, col)) {
        System.out.println("Invalid Move!");
        continue;
      }
      if(ctr % 2 == 0) {
        // player 1
        try {
          TicTacToeMove ticTacToeMove = new TicTacToeMove(row, col, "p1");
          boolean isWinningMove = gameService.move(ticTacToeMove, "b1");
          gameService.displayBoard("b1");
          if(isWinningMove) {
            System.out.println(player1.getName()+" won the game!");
            running = false;
            break;
          }
          ctr++;
        } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Please re enter the row and column number!");
        }

      } else {
        // player 2
        try {
          TicTacToeMove ticTacToeMove = new TicTacToeMove(row, col, "p2");
          boolean isWinningMove = gameService.move(ticTacToeMove, "b1");
          gameService.displayBoard("b1");
          if(isWinningMove) {
            System.out.println(player2.getName()+" won the game!");
            running = false;
            break;
          }
          ctr++;
        } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Please re enter the row and column number!");
        }
      }
    }
  }

  private static boolean isValidCell(int x, int y) {
    return x >= 0 && x < 3 && y >= 0 && y < 3;
  }
}

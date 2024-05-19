package com.game.snakeLadder;

import com.game.snakeLadder.model.Board;
import com.game.snakeLadder.model.Dicee;
import com.game.snakeLadder.model.GameState;
import com.game.snakeLadder.model.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    public static Map<Integer, Integer> takeMapInput(int count) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            map.put(start, end);
        }
        return map;
    }

    public static int findNextPosition(int currentLocation, int rollValue, Board board){
        int immediateNextPosition = currentLocation + rollValue;
        if(immediateNextPosition > 100) {
            return currentLocation;
        }

        Map<Integer, Integer> ladderMap = board.getLadderMap();
        Map<Integer, Integer> snakeMap = board.getSnakeMap();
        while (ladderMap.containsKey(immediateNextPosition) ||
                snakeMap.containsKey(immediateNextPosition)) {

            if (ladderMap.containsKey(immediateNextPosition)) {
                immediateNextPosition = ladderMap.get(immediateNextPosition);
            }

            if (snakeMap.containsKey(immediateNextPosition)){
                immediateNextPosition = snakeMap.get(immediateNextPosition);
            }
        }

        return immediateNextPosition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game started");

        // take snake input
        int snakeCount = scanner.nextInt();
        Map<Integer, Integer> snakeMap = takeMapInput(snakeCount);

        // take ladder input
        int ladderCount = scanner.nextInt();
        Map<Integer, Integer> ladderMap = takeMapInput(ladderCount);

        // setting board
        Board board = new Board(snakeMap, ladderMap);

        // take players input
        int playerCount = scanner.nextInt();
        Deque<Player> players = new ArrayDeque<>();
        Player[] playerArray = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            String name = scanner.next();
            Player player = new Player(name, 1);
            players.add(player);
            playerArray[i] = player;
        }

        // set game state
        GameState gameState = new GameState(false, playerArray);
        Dicee dice = new Dicee(1);

        // game runs until winner is decided
        while (!gameState.isGameOver()) {
            Player p = players.removeFirst();
            int rollValue = dice.roll();
            int nextPosition = findNextPosition(p.getCurrentCell(), rollValue, board);
            if(nextPosition == 100){
                System.out.println("Game over");
                System.out.println("Player: "+p.getName()+" rolled: "+rollValue+" moved from : "+p.getCurrentCell()+" to: "+nextPosition);
                System.out.println("Player "+p.getName()+" has won the game");
                gameState.setGameOver(true);
                gameState.setWinner(p);
                break;
            }
            System.out.println("Player: "+p.getName()+" rolled: "+rollValue+" moved from : "+p.getCurrentCell()+" to: "+nextPosition);
            p.setCurrentCell(nextPosition);
            players.addLast(p);
        }
    }
}

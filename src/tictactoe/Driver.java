package tictactoe;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("What board size you want to play? \n");
        Scanner sc = new Scanner(System.in);

        int dimension = sc.nextInt();

        Board board = new Board(dimension);

        Player playerA = new Player("Alice", SignType.CROSS);
        Player playerB = new Player("Bob", SignType.ZERO);

        Game tictactoe = new Game(board, playerA, playerB);

        System.out.println("Launching the game");
        tictactoe.launch();
    }
}

/*
0. tictactoe.Driver - which start the game
1. Game
2. Board - n
3. Player - name, signType
4. SignType - Enum - CROSS, ZERO
 */
package tictactoe;

import java.util.Scanner;

public class Game {
    private final Player playerA;
    private final Player playerB;
    private final Board board;
    private Boolean winner;
    private Boolean draw;
    private SignType turn;

    public Game(Board board, Player playerA, Player playerB) {
        this.board = board;
        this.playerA = playerA;
        this.playerB = playerB;
        this.turn = SignType.CROSS;
        this.winner = false;
        this.draw = false;
    }

    public void launch() {
        while (!this.winner && !this.draw) {
            System.out.println("Player" + (turn == SignType.CROSS ? "A" : "B") + " turn: Please enter your sign position: ");
            this.board.printBoard();
            System.out.println();

            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (this.board.validateInput(x, y)) {
                continue;
            }

            this.board.updateBoard(x, y, turn);

            if (this.board.checkForWinner(x, y)) {
                this.winner = true;
                break;
            }

            if (this.board.checkForDraw()) {
                this.draw = true;
                break;
            }

            if (turn == SignType.CROSS) turn = SignType.ZERO;
            else turn = SignType.CROSS;
        }

        if (this.draw) {
            System.out.println("Game Draw!!");
            this.board.printBoard();
        } else {
            if (turn == SignType.CROSS) {
                System.out.println(this.playerA.getName() + " wins!!");
            } else {
                System.out.println(this.playerB.getName() + " wins!!");
            }
            this.board.printBoard();
        }
    }
}

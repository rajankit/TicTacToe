package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int boardSize;
    private final char[][] board;
    private final int[] rows;
    private final int[] cols;

    private int diagonal;
    private int antiDiagonal;

    private final int[] rowsX;
    private final int[] colsX;

    private int diagonalX;
    private int antiDiagonalX;

    public Board(int dimension) {
        this.boardSize = dimension;
        this.board = new char[dimension + 1][dimension + 1];
        this.rows = new int[dimension + 1];
        this.cols = new int[dimension + 1];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        this.rowsX = new int[dimension + 1];
        this.colsX = new int[dimension + 1];
        this.diagonalX = 0;
        this.antiDiagonalX = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 1; i <= this.boardSize; i++) {
            for(int j = 1; j <= this.boardSize; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void printBoard() {
        for(int i = 1; i <= this.boardSize; i++) {
            for(int j = 1; j <= this.boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkForDraw() {
        for(int i = 1; i <= this.boardSize; i++) {
            for(int j = 1; j <= this.boardSize; j++) {
                if (this.board[i][j] == '.') return false;
            }
        }

        return true;
    }

    public boolean checkForWinner(int x, int y) {
        return (
                this.rows[x] == this.boardSize ||
                this.rowsX[x] == this.boardSize ||
                this.cols[y] == this.boardSize ||
                this.colsX[y] == this.boardSize ||
                this.diagonal == this.boardSize ||
                this.antiDiagonal == this.boardSize ||
                this.diagonalX == this.boardSize ||
                this.antiDiagonalX == this.boardSize
                );
    }

    public boolean validateInput(int x, int y) {
        boolean inputIsValid = false;

        if (x < 1 || x > this.boardSize || y < 1 || y > this.boardSize) {
            System.out.println("Position out of bound, Please enter correct position.");
            inputIsValid = true;
        } else {
            if (this.board[x][y] != '.') {
                System.out.println("Cell already filled, Please enter correct position.");
                inputIsValid = true;
            }
        }

        return inputIsValid;
    }

    public void updateBoard(int x, int y, SignType signType) {
        if (signType == SignType.CROSS) {
            board[x][y] = 'X';
            rowsX[x]++;
            colsX[y]++;

            if (x == y) diagonalX++;
            if (x == 1 + this.boardSize - y) {
                antiDiagonalX++;
            }
        } else {
            board[x][y] ='O';
            rows[x]++;
            cols[y]++;
            if (x == y) diagonal++;
            if (x == 1 + this.boardSize - y) {
                antiDiagonal++;
            }
        }

    }
}

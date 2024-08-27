import java.util.*;
import java.io.*;

class Board {
    private int N;
    private int[][] board;
    private int maxBlock;

    public Board(int N) {
        this.N = N;
        this.board = new int[N][N];
        this.maxBlock = 0;
    }

    public void setBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            this.board[i] = board[i].clone();
        }
    }

    public int getMaxBlock() {
        return maxBlock;
    }

    public void move(int direction) {
        switch (direction) {
            case 0: moveUp(); break;
            case 1: moveDown(); break;
            case 2: moveLeft(); break;
            case 3: moveRight(); break;
        }
    }

    private void moveUp() {
        for (int j = 0; j < N; j++) {
            int index = 0;
            int block = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[index - 1][j] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[index][j] = block;
                        index++;
                    }
                }
            }
        }
    }

    private void moveDown() {
        for (int j = 0; j < N; j++) {
            int index = N - 1;
            int block = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[index + 1][j] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[index][j] = block;
                        index--;
                    }
                }
            }
        }
    }

    private void moveLeft() {
        for (int i = 0; i < N; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][index - 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < N; i++) {
            int index = N - 1;
            int block = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][index + 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }

    public void updateMaxBlock() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
    }

    public int[][] getBoard() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }
}

public class Main {
    static int N;
    static Board board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new Board(N);

        int[][] initialBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                initialBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board.setBoard(initialBoard);

        dfs(0);
        System.out.println(board.getMaxBlock());
    }

    static void dfs(int depth) {
        if (depth == 5) {
            board.updateMaxBlock();
            return;
        }

        int[][] temp = board.getBoard();
        for (int i = 0; i < 4; i++) {
            board.move(i);
            dfs(depth + 1);
            board.setBoard(temp);
        }
    }
}
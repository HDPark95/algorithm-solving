import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(n, 0, 0);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }

    static void divide(int size, int x, int y) {
        int color = board[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != color) {
                    int half = size / 2;
                    divide(half, x, y);
                    divide(half, x + half, y);
                    divide(half, x, y + half);
                    divide(half, x + half, y + half);
                    return;
                }
            }
        }
        count[color]++;
    }
}

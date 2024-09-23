import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int total;
    static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] memo;
    static int M, N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            K = Integer.parseInt(inputs[2]);

            memo = new int[M][N];
            for (int j = 0; j < K; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                memo[x][y] = 1;
            }

            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (memo[x][y] == 1) {
                        DFS(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void DFS(int x, int y) {
        memo[x][y] = 0;
        for (int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && memo[nextX][nextY] == 1) {
                DFS(nextX, nextY);
            }
        }
    }
}

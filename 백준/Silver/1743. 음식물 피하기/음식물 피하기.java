
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M, K;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);

        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            String[] locations = br.readLine().split(" ");
            int x = Integer.parseInt(locations[0]) - 1;
            int y = Integer.parseInt(locations[1]) - 1;
            map[x][y] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 1){
                count += dfs(nx, ny);
            }
        }
        return count;
    }
}

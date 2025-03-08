import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        cnt = 0;
        dfs(startX, startY);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (campus[x][y] == 'P') {
            cnt++;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && campus[nx][ny] != 'X') {
                    dfs(nx, ny);
                }
            }
        }
    }
}

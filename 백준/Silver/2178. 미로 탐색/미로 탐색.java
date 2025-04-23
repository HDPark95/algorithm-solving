import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y;

        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[ny][nx] || map[ny][nx] == 0) continue;

                queue.add(new Node(ny, nx));
                visited[ny][nx] = true;
                map[ny][nx] = map[current.y][current.x] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split(" ");
        N = Integer.parseInt(sizes[0]);
        M = Integer.parseInt(sizes[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1]);
    }
}

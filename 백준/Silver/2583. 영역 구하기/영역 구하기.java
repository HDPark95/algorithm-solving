import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int M, N, K;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] layout = br.readLine().split(" ");
        M = Integer.parseInt(layout[0]);
        N = Integer.parseInt(layout[1]);
        K = Integer.parseInt(layout[2]);

        graph = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
            rectangle.fill(graph);
        }
        int count = 0;
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && !graph[i][j]){
                    int area = dfs(i, j);
                    if (area > 0) {
                        areas.add(area);
                        count++;
                    }
                }
            }
        }

        areas.sort(null);

        System.out.println(count);
        for (int i = 0; i < areas.size(); i++) {
            System.out.print(areas.get(i));
            if (i < areas.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static class Rectangle{
        public int x1, y1, x2, y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public void fill(boolean[][] graph){
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    graph[i][j] = true;
                }
            }
        }
    }
    static int dfs(int x, int y){
        if (x < 0 || x >= M || y < 0 || y >= N || visited[x][y] || graph[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            area += dfs(nx, ny);
        }

        return area;
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        buildWall(0);
        System.out.println(max);
    }

    public static void buildWall(int count) {
        if (count == 3) {
            int[][] copiedMap = copy(map);
            // 바이러스 퍼트리기
            afterVirus(copiedMap);
            // 0의 갯수 세기
            max = Math.max(max, countZero(copiedMap));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static int[][] copy(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, M);
        }
        return copy;
    }

    public static void afterVirus(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 위치를 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // BFS로 바이러스 확산
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pos[0] + dx[k];
                int ny = pos[1] + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 2;  // 바이러스 확산
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int countZero(int[][] map){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

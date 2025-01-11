import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*  슈도 코드
*  외곽의 치즈는 사라짐
*  치즈가 모두 없어 질 때 까지 반복하고 마지막 치즈의 수를 세야함
*  외곽을 어떻게 정의해야할까?
*  상하 좌우에 0이 있으면 외곽임. 대각선은 아님
*
* */
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int totalCount;
    static int lastMeltedCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int cheeze = Integer.parseInt(input[j]);
                totalCount += cheeze;
                map[i][j] = cheeze;
            }
        }
        int totalLoop = 0;
        while(totalCount > 0){
            bfs();
            totalLoop++;
        }
        System.out.println(totalLoop);
        System.out.println(lastMeltedCount);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        int meltedCount = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                }else{
                    meltedCount++;
                    map[nx][ny] = 0;
                }
            }
        }
        totalCount -= meltedCount;
        lastMeltedCount = meltedCount;
    }
}
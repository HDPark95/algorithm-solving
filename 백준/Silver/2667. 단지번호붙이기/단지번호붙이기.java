import java.io.BufferedReader;
import java.util.*;


/*
* ### 슈도 코드

- 모듈화
    1. 입력값 받기

    1. 행렬에서 단지 구분하기 (BFS)
        - 방문 여부 배열 초기화
        - 상하좌우 이동 셋팅
        - 정답 배열 셋팅
        - 행렬을 이동하며 1 찾기
            - 방문하지 않았을 경우

            가구 큐 생성

            상하좌우 인접노드 찾기

            - 인접 노드가 있을 경우

                가구 큐 넣기

            - 인접 노드가 없을 경우

                정답배열에 가구 큐 넣기


    2. 정답배열 사이즈 출력
    3. 정답배열의 큐 사이즈를 정렬하여 출력
*
*
* */
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy= {1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j);
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(Integer q: answer){
            System.out.println(q);
        }
    }

    public static void bfs(int x, int y){
        if (visited[x][y] || map[x][y] == 0){
            return;
        }
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        int groupCount = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        groupCount++;
                    }
                }
            }
        }
        answer.add(groupCount);
    }
}
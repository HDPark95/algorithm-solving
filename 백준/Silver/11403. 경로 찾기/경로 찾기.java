import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static ArrayList<Set<Integer>> connectList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            connectList.add(new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        
        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (connectList.get(i).contains(j)) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];  
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next = 0; next < N; next++) {
                
                if (map[current][next] == 1 && !visited[next]) {
                    visited[next] = true;  
                    connectList.get(start).add(next);
                    queue.add(next);  
                }
            }
        }
    }
}
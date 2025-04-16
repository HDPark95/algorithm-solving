import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int N, M, R;
    public static int[] visitedCount;
    public static ArrayList<Integer>[] graph;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);

        visitedCount = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort((o1, o2) -> o2 - o1); // 내림차순 정렬
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitedCount[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int nodeIndex) {
        visitedCount[nodeIndex] = order++;
        for (int next : graph[nodeIndex]) {
            if (visitedCount[next] == 0) {
                dfs(next);
            }
        }
    }
}

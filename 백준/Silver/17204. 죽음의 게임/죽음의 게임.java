import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] layout = br.readLine().split(" ");
        N = Integer.parseInt(layout[0]);
        M = Integer.parseInt(layout[1]);
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0);
        System.out.println(answer);
    }
    public static void dfs(int current, int count) {
        if (visited[current]) {
            return;
        }

        if (current == M) {
            answer = count;
            return;
        }

        visited[current] = true;
        dfs(arr[current], count + 1);
    }
}

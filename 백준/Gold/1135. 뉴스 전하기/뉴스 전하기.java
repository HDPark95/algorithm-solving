import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        
        visited = new boolean[N];
        time = new int[N];
        tree = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            int parent = Integer.parseInt(inputs[i]);
            tree[parent].add(i);
        }

        dfs(0);
        System.out.println(time[0]);
    }

    public static void dfs(int node) {
        visited[node] = true;
        ArrayList<Integer> childTimes = new ArrayList<>();

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                childTimes.add(time[child]);
            }
        }
        
        Collections.sort(childTimes, Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < childTimes.size(); i++) {
            maxTime = Math.max(maxTime, childTimes.get(i) + i + 1);
        }

        time[node] = maxTime;
    }
}

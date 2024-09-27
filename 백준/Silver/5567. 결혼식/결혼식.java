
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static Set<Integer> friends = new HashSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        visited[1] = true;
        dfs(1, 0);
        System.out.println(friends.size());
    }

    public static void dfs(int node, int depth){
        List<Integer> integers = graph[node];
        for (int i = 0; i < integers.size(); i++) {
            int next = integers.get(i);
            if(!visited[next] && depth < 2){
               visited[next] = true;
               friends.add(next);
               dfs(next, depth+1);
               visited[next] = false;
            }
        }
    }
}

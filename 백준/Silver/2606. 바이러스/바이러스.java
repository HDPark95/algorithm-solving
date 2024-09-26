
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int N;
    public static int M;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        graph = new List[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int node) {
        List<Integer> integers = graph[node];
        for (Integer connectedNode : integers) {
            if(!visited[connectedNode]){
                count++;
                visited[connectedNode] = true;
                dfs(connectedNode);
            }
        }
    }
}

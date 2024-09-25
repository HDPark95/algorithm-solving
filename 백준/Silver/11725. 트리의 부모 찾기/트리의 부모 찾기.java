
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
        tree = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
    public static int dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < tree[node].size(); i++) { // 자식 노드들을 방문
            int next = tree[node].get(i); // 다음 노드
            if (!visited[next]) { // 방문하지 않았다면
                parent[next] = node; // 부모 노드를 저장
                dfs(next);
            }
        }
        return 0;
    }
}
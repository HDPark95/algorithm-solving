
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N, M;
    static List<List<Integer>> map = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] layer =  br.readLine().split(" ");
        N = Integer.parseInt(layer[0]);
        M = Integer.parseInt(layer[1]);

        for (int i = 0; i < N+1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            int a = Integer.parseInt(nodes[0]);
            int b = Integer.parseInt(nodes[1]);

            map.get(a).add(b);
            map.get(b).add(a);
        }
        int minIndex =0;
        for (int i = 1; i < N+1; i++) {
            if (min > bfs(i)){
                min = Math.min(min, bfs(i));
                minIndex= i;
            }
        }
        System.out.println(minIndex);
    }

    public static int bfs(int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});

        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        int result = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int currentNode = now[0];
            int depth = now[1];
            result += depth;
            List<Integer> nodes = map.get(currentNode);
            for (Integer node : nodes) {
                if (!visited[node]) {

                    queue.add(new int[]{node, depth+1});
                    visited[node] = true;
                }
            }
        }
        return result;
    }
}

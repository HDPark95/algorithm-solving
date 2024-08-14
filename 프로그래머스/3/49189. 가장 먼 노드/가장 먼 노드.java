import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i <n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distances = bfs(n, graph);
        Arrays.sort(distances);
        int max = distances[distances.length - 1];
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == max) {
                answer++;
            }
        }
        return answer;
    }
    
    public int[] bfs(int n, List<List<Integer>> graph) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }
}
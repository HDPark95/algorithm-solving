import java.util.*;

class Solution {
    List<List<Integer>> winnerGraph  = new ArrayList<>();;
    List<List<Integer>> looseGraph  = new ArrayList<>();;
    boolean visited[];
    
    public int solution(int n, int[][] results) {
        for (int i = 0; i <= n; i++) {
            winnerGraph.add(new ArrayList<>());
            looseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int looser = results[i][1];
            winnerGraph.get(winner).add(looser);
            looseGraph.get(looser).add(winner);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int winnerCount = dfs(i, winnerGraph) - 1;
            visited = new boolean[n + 1];
            int looserCount = dfs(i, looseGraph) - 1;
            if (winnerCount + looserCount == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
     private int dfs(int current, List<List<Integer>> graph) {
        visited[current] = true;
        int count = 1; 
        for (int next : graph.get(current)) {
            if (!visited[next]) {
                count += dfs(next, graph);
            }
        }
        return count;
    }
}
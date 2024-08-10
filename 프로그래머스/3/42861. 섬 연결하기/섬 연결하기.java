import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
       List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] cost : costs) {
            graph[cost[0]].add(new int[]{cost[1], cost[2]});
            graph[cost[1]].add(new int[]{cost[0], cost[2]});
        }

        // 최소 비용을 계산하기 위한 우선순위 큐 사용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n];
        int mstCost = 0;
        int edgesUsed = 0;

        // 임의의 정점(여기서는 0번 정점)을 시작점으로 선택
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty() && edgesUsed < n) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            // 이미 방문한 노드는 무시
            if (visited[currentNode]) continue;

            // 노드를 MST에 추가
            visited[currentNode] = true;
            mstCost += currentCost;
            edgesUsed++;

            // 인접한 노드들을 큐에 추가
            for (int[] neighbor : graph[currentNode]) {
                if (!visited[neighbor[0]]) {
                    pq.add(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }

        return mstCost;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 인접 리스트를 사용해 그래프를 구성
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        
        // 경로를 저장할 리스트
        LinkedList<String> route = new LinkedList<>();
        
        // DFS를 역순으로 탐색
        dfs("ICN", graph, route);
        
        // 경로를 리스트에서 배열로 변환하여 반환
        return route.toArray(new String[0]);
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, route);
        }
        
        // 후입선출 구조를 위해 역순으로 삽입
        route.addFirst(airport);
    }
}

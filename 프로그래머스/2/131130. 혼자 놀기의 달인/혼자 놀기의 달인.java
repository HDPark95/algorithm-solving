import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groups = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int groupSize = getGroupSize(cards, visited, i);
                groups.add(groupSize);
            }
        }
        
        if (groups.size() == 1) {
            return 0;
        }
        
        Collections.sort(groups, Collections.reverseOrder());
        return groups.get(0) * groups.get(1);
    }
    
    private int getGroupSize(int[] cards, boolean[] visited, int start) {
        int size = 0;
        int current = start;
        
        while (!visited[current]) {
            visited[current] = true;
            size++;
            current = cards[current] - 1;
        }
        
        return size;
    }
}
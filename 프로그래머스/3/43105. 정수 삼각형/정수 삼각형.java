class Solution {
    int[][] memo;
    public int solution(int[][] triangle) {
        memo = new int[triangle.length][triangle.length];
        return dfs(triangle, 0, 0);
    }
    
    private int dfs(int[][] triangle, int x, int y) {
        if (x == triangle.length) { // 마지막 줄에 도달했을 때
            return 0;
        }
        if (memo[x][y] != 0) { // 이미 방문한 적이 있을 때
            return memo[x][y];
        }
        // 현재 위치의 값과 아래 두 값 중 큰 값을 더함
        memo[x][y] = triangle[x][y] + // 현재 위치의 값
                Math.max(dfs(triangle, x + 1, y), // 왼쪽 아래 값
                        dfs(triangle, x + 1, y + 1)); // 오른쪽 아래 값

        return memo[x][y];
    }
}
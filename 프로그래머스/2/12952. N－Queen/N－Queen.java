class Solution {
    int N;
    int[] visited; 
    int answer = 0;
    public int solution(int n) {
        N = n;
        visited = new int[N];
        dfs(0);
        return answer;
    }
    public void dfs(int checked){
         if (checked == N){
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (canCheck(checked, i)){
                visited[checked] = i;
                dfs(checked + 1);
            }
        }
    }

    public boolean canCheck(int row, int col){
         for (int i = 0; i < row; i++) {
            if(visited[i] == col){ //가로 확인
                return false;
            }else if(Math.abs(row - i) == Math.abs(col - visited[i])){ //대각선 확인
                return false;
            }
        }
        return true;
    }
}
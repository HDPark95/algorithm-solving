class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        
        // 문제들 중에서 가장 큰 요구 알고력과 코딩력 계산
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        // 초기 알고력과 코딩력이 이미 최대치 이상이면 값을 조정
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        // DP 테이블 초기화 (int 최대값으로 초기화)
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        // DP 진행
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 알고력 증가
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                // 코딩력 증가
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                // 문제를 풀어서 얻을 수 있는 경우
                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];
                    
                    if (i >= alpReq && j >= copReq) {
                        int newAlp = Math.min(maxAlp, i + alpRwd);
                        int newCop = Math.min(maxCop, j + copRwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}

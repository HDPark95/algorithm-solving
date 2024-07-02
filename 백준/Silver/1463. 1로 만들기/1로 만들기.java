import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /* 백준 1463 1로 만들기 문제 */
    /* 재귀 함수로 풀기 */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] dp = new int[number + 1];
        dp[1] = 0;
        for(int i = 2; i <= number; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[number]);
    }
}
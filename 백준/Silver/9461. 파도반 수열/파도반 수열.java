
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(solution(N)).append("\n");
        }
        System.out.println(sb);
    }
    public static long solution(int N){
        long[] dp = new long[N];
        for (int i = 0; i < N; i++) {
            if(i > 2){
                dp[i] = dp[i-2] + dp[i-3];
            }else{
                dp[i] = 1;
            }
        }
        return dp[dp.length-1];
    }
}

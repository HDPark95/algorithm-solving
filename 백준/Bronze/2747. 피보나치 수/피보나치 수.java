import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        dp = new int[number+1];
        System.out.println(fiibonacci(number));
    }
    public static int fiibonacci(int i){
        if (i == 0) return 0;
        if (i == 1) return 1;

        if (dp[i] != 0){
            return dp[i];
        }
        dp[i] = fiibonacci(i-1) + fiibonacci(i-2);
        return dp[i];
    }
}

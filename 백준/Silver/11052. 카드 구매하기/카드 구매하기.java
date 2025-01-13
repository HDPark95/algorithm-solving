import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> cardPacks = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] stringPacks = br.readLine().split(" ");
        for (String packs: stringPacks){
            cardPacks.add(Integer.parseInt(packs));
        }

        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + cardPacks.get(j-1));
            }
        }
        System.out.println(dp[N]);
    }
}

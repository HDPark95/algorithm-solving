import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int result = 0;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        memo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0, false); 
        System.out.println(result);
    }

    public static void solution(int n, int sum, boolean isNonEmpty) {
        if (n == N) {
            if (sum == S && isNonEmpty) {
                result++;
            }
            return;
        }
        
        solution(n + 1, sum + memo[n], true);

        solution(n + 1, sum, isNonEmpty);
    }
}
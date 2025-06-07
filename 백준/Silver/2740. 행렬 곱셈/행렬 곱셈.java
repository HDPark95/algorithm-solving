import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K;
    static int[][] aMap;
    static int[][] bMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] aShape = br.readLine().split(" ");
        N = Integer.parseInt(aShape[0]);
        M = Integer.parseInt(aShape[1]);

        aMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] aRows = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                aMap[i][j] = Integer.parseInt(aRows[j]);
            }
        }

        String[] bShape = br.readLine().split(" ");
        M = Integer.parseInt(bShape[0]);
        K = Integer.parseInt(bShape[1]);
        bMap = new int[M][K];
        for (int i = 0; i < M; i++) {
            String[] bRows = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                bMap[i][j] = Integer.parseInt(bRows[j]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += aMap[i][k] * bMap[k][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

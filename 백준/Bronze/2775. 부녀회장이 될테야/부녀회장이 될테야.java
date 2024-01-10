import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Test case의 수를 읽음

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // k 값을 읽음
            int n = Integer.parseInt(br.readLine()); // n 값을 읽음

            int[][] apt = new int[k + 1][n]; // 아파트 배열 초기화

            // 0층 초기화
            for (int i = 0; i < n; i++) {
                apt[0][i] = i + 1;
            }

            // k층까지 계산
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l <= j; l++) {
                        apt[i][j] += apt[i - 1][l];
                    }
                }
            }

            System.out.println(apt[k][n - 1]); // 결과 출력
        }
    }
}
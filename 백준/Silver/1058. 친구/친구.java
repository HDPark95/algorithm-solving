import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[][] map;
    private static final int INF = 1000000000; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = (line.charAt(j) == 'Y') ? 1 : INF;
                }
            }
        }

        for (int k = 0; k < N; k++) {        
            for (int i = 0; i < N; i++) {     
                for (int j = 0; j < N; j++) { 
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (map[i][j] <= 2) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}

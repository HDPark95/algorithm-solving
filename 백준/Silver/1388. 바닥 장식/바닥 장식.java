import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N,M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map [i][j] = line[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    dfs(i,j);
                    ans +=1;
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        char block = map[x][y];
        if (block == '-'){
            if (y+1 < M && map[x][y+1] == '-' && ! visited[x][y+1]) {
                dfs(x, y+1);
            }
        }else{
            if (x+1 < N && map[x+1][y] == '|' && ! visited[x+1][y]) {
                dfs(x+1, y);
            }
        }
    }
}

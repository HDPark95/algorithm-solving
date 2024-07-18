import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1. 아이디어
* 백트래킹
* BFS
* -12 +13 ;14
*    ;23 +24
*       -34
* 2. 자료구조
*
*
* */
public class Main {

    static int n;
    static int[][] inputs;
    static boolean[] visited;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inputs = new int[n][n];
        StringTokenizer st;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        solution(0, 0);
        System.out.println(min);
    }
    public static void solution(int cur, int check){
        if(check == n/2 || cur == n){
            if(check == n/2){
                calculate();
            }
            return;
        }
        for (int i = cur; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                solution(i+1, check+1);
                visited[i] = false;
            }
        }
    }
    public static void calculate(){
        int team1 = 0;
        int team2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(visited[i] && visited[j]){
                    team1 += inputs[i][j];
                }else if(!visited[i] && !visited[j]){
                    team2 += inputs[i][j];
                }
            }
        }
        min = Math.min(min, Math.abs(team1 - team2));
    }
}

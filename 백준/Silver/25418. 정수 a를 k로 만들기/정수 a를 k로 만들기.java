
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int N, M;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[M+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        while(!queue.isEmpty()){
            int[] start = queue.poll();
            int point = start[0];
            int depth = start[1];
            if (point == M){
                System.out.println(start[1]);
                break;
            }
            if (point * 2 <= M){
                visited[point*2] = true;
                queue.add(new int[]{point*2, depth+1});
            }
            if (point + 1 <= M){
                if (!visited[point+1]){
                    queue.add(new int[]{point+1, depth+1});
                }
            }
        }
    }
}
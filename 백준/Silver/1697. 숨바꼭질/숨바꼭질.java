import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new boolean[100001];
        System.out.println(bfs(N));
    }

    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int move = 0;
         while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    return move;
                }

                int[] nextPositions = {current + 1, current - 1, current * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }

}
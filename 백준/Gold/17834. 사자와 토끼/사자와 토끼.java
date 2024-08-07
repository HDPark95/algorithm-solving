
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* 아이디어
*
* 1. 이진그래프인지 판별
* 2. 이진그래프가 아니라면 0 반환
* 3. 이진그래프라면 사자와 토끼가 각각 다른 팀인지 확인하고 다른팀인 경우의 수 구하기
*
* */
public class Main {
    static int node;
    static int edge;
    static int[] color;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        node = Integer.parseInt(inputs[0]);
        edge = Integer.parseInt(inputs[1]);
        graph = new ArrayList[node+1];
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        color = new int[node+1];
        Arrays.fill(color, -1);

        long[] result = bfs(1);

        if (result == null) {
            System.out.println(0);
        } else {
            System.out.println(result[0] * result[1] * 2);
        }
    }
     static long[] bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        long[] counts = new long[2];
        counts[0] = 1;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int neighbor : graph[v]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[v];
                    counts[color[neighbor]]++;
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[v]) {
                    return null;
                }
            }
        }

        return counts;
    }
}

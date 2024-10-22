import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static List<List<Integer>> map = new ArrayList<>();
    static int[] answers;
    static int[] compliment;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        answers = new int[N + 1];
        compliment = new int[N + 1];

        String[] parents = br.readLine().split(" ");
        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            int parent = Integer.parseInt(parents[i]);
            if (parent != -1) {
                map.get(parent).add(i + 1);
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int child = Integer.parseInt(input[0]);
            int power = Integer.parseInt(input[1]);
            compliment[child] += power;
        }

        dfs(1, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int node, int acc) {
        acc += compliment[node];
        answers[node] = acc;

        for (Integer child : map.get(node)) {
            dfs(child, acc);
        }
    }
}

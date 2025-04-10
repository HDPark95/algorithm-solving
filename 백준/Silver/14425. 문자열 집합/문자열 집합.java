import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String word = br.readLine();
            if (wordSet.contains(word)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
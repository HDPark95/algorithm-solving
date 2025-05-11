
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        List<Integer> result = new ArrayList<>();

        for (int i = N; i >= 1; i--) {
            int left = Integer.parseInt(inputs[i-1]);
            result.add(left, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int person : result) {
            sb.append(person).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

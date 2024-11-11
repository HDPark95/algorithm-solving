
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        PriorityQueue<Integer> books = new PriorityQueue<>((o1, o2) -> {
            if (o1 > 0 && o2 > 0) {
                return o2 - o1;
            }
            return o1- o2;
        });

        String[] inputBooks = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(inputBooks[i]);
            books.add(value);
        }
        int distance = 0;
        int maxIndex = 0;
        while (!books.isEmpty()) {
            int current = books.poll();
            maxIndex = Math.max(maxIndex, Math.abs(current));
            int currentAbs = Math.abs(current);
            for (int i = 0; i < M - 1; i++) {
                if (books.isEmpty()) {
                    break;
                }

                int next = books.peek();

                if (next > 0 && current > 0 || next < 0 && current < 0) {
                    books.poll();
                } else {
                    break;
                }
            }
            distance += (currentAbs * 2);
        }
        System.out.println(distance - maxIndex);
    }

}

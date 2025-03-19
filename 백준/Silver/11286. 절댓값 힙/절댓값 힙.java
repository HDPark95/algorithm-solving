
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 - abs2 == 0){
                    return o1 - o2;
                }else{
                    return abs1 - abs2;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            Integer input = Integer.parseInt(br.readLine());
            if (input == 0){
                if (queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.offer(input);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        
        int totalOperations = 0;
        for (int target : targets) {
            int index = deque.indexOf(target);
            int size = deque.size();
            if (index <= size / 2) {
                for (int i = 0; i < index; i++) {
                    deque.addLast(deque.removeFirst());
                    totalOperations++;
                }
            } else {
                for (int i = 0; i < size - index; i++) {
                    deque.addFirst(deque.removeLast());
                    totalOperations++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(totalOperations);
    }
}

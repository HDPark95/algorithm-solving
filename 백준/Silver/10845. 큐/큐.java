import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<String> commandQueue = new LinkedList<>();
        Queue<Integer> numberQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            CommandType command = CommandType.valueOf(inputs[0].toUpperCase());

            switch (command) {
                case PUSH:
                    commandQueue.offer(inputs[0]);
                    numberQueue.offer(Integer.parseInt(inputs[1]));
                    break;
                case POP:
                    if(numberQueue.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(numberQueue.poll());
                    }
                    break;
                case SIZE:
                    System.out.println(numberQueue.size());
                    break;
                case EMPTY:
                    if(numberQueue.isEmpty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case FRONT:
                    if(numberQueue.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(numberQueue.peek());
                    }
                    break;
                case BACK:
                    if(numberQueue.isEmpty()){
                        System.out.println(-1);
                    } else {
                        int last = 0;
                        for (int number : numberQueue) {
                            last = number;
                        }
                        System.out.println(last);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public enum CommandType {
        PUSH,
        POP,
        SIZE,
        EMPTY,
        FRONT,
        BACK;
    }
}

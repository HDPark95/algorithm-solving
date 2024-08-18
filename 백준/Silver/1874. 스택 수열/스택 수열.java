import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            while (now <= number) {
                stack.push(now);
                now++;
                sb.append("+\n");
            }
            if (stack.peek() == number) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}

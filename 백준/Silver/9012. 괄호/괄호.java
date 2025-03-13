import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

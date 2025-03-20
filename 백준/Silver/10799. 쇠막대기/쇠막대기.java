import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '('){
                stack.add(st.charAt(i));
            }else{
                stack.pop();
                if ('(' == st.charAt(i-1)){
                    answer+=stack.size();
                }else{
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
  public static Integer N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      Integer price = Integer.parseInt(br.readLine());
      if (price == 0){
        stack.pop();
      }else{
        stack.push(price);
      }
    }
    Integer result = 0;
    for(Integer price: stack){
      result += stack.pop();
    }
    System.out.println(result);
  }

}

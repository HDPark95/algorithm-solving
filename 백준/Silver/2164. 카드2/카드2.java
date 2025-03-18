import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
*
* 바닥에 버린다.
* 제일 위의 카드를 제일 아래로 내린다
*
* */
public class Main {
    public static Integer N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int idx = 0;
        int answer = 0;
        while (!queue.isEmpty()){
            answer = queue.poll();
            if (idx % 2 != 0){
                queue.add(answer);
            }
            idx++;
        }
        System.out.println(answer);
    }
}
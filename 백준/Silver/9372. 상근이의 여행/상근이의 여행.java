import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * INPUT : 2 테스트 케이스 수
 * N, M : 국가의 수, 비행기의 종류
 *
 * */
public class Main {
  public static int N;
  public static ArrayList<Integer>[] graph;
  public static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] inputs = br.readLine().split(" ");
      int x = Integer.parseInt(inputs[0]);
      int y = Integer.parseInt(inputs[1]);

      graph = new ArrayList[x+ 1];

      for (int j = 0; j < y; j++) {
        br.readLine();
      }
      System.out.println(x -1);
    }
  }
}
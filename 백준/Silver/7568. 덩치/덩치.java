import java.io.*;
import java.util.*;

public class Main {
    private static int N;

    static class Size implements Comparable<Size> {
        int weight;
        int height;
        int rank;  // 초기값은 1로 시작 (자신보다 덩치가 큰 사람이 없으면 1등)

        Size(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }

        @Override
        public int compareTo(Size o) {
            if(this.weight == o.weight) {
                return this.height - o.height;
            }
            return this.weight - o.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Size[] arr = new Size[N];
        
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int weight = Integer.parseInt(inputs[0]);
            int height = Integer.parseInt(inputs[1]);
            arr[i] = new Size(weight, height);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                if(arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
                    arr[i].rank++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].rank).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
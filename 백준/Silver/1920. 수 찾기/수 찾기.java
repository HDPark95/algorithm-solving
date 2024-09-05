
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputs[i]);
        }
        int M = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(A);
        for (int i = 0; i < B.length; i++) {
            if(Arrays.binarySearch(A,B[i]) >= 0){
                System.out.println(1);
            }else{
                System.out.println(0);
            };
        }
    }

}

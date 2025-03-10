import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < n / 2; i++) {
            int temp = B[i];
            B[i] = B[n - 1 - i];
            B[n - 1 - i] = temp;
        }
        
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) A[i] * B[i];
        }
        
        System.out.println(result);
    }
}

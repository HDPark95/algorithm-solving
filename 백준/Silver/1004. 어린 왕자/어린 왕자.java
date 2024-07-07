
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int cases = Integer.parseInt(br.readLine());
            int result = 0;
            for (int j = 0; j < cases; j++) {
                String[] one = br.readLine().split(" ");
                //case 한점은 안에 한점은 밖에 있는 경우
                int cx = Integer.parseInt(one[0]);
                int cy = Integer.parseInt(one[1]);
                int r = Integer.parseInt(one[2]);
                double sqrt = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
                double sqrt1 = Math.sqrt(Math.pow(cx - x2,2 ) + Math.pow(cy - y2,2));
                if((sqrt > r && sqrt1 < r) || (sqrt < r && sqrt1 > r)){
                    result++;
                }
            }
            System.out.println(result);
        }

    }
}

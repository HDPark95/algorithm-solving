import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            int a = Integer.parseInt(values[0]) % 10;
            int b = Integer.parseInt(values[1]);
            if(a == 0){
                result.add(10);
                continue;
            }
            int one = a;
            for (int j = 1; j < b; j++) {
                one = one * a % 10;
                if(one == 0){
                    one = 10;
                    break;
                }
            }
            result.add(one);
        }
        result.stream().forEach(System.out::println);
    }
}

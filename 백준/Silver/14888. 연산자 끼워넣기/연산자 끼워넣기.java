import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //0=+,1=-,2=*,3=/
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> allCase = new ArrayList<>();
        solution(0, N, inputs[0], inputs, operators, allCase);
        System.out.println(Collections.max(allCase));
        System.out.println(Collections.min(allCase));
    }

    public static void solution(int num, int N, int a, int[] inputs, int[] operator, List<Integer> result){
        if(num == N-1){
            result.add(a);
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if(operator[i] != 0){
                operator[i] = operator[i]-1;
                solution(num+1, N, calculate(a, inputs[num+1], i), inputs, operator, result);
                operator[i] = operator[i]+1;
            }
        }
    }

    public static int calculate(int a, int b, int operatorIndex){
        if (operatorIndex == 0){
            return a+b;
        } else if (operatorIndex == 1) {
            return a-b;
        } else if (operatorIndex == 2) {
            return a*b;
        } else if (operatorIndex == 3) {
            if(a > 0){
                return a/b;
            }else{
                return a/b;
            }
        }
        return 0;
    }
}

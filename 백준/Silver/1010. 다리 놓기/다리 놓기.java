
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++){
            List<String> list = Arrays.asList(br.readLine().split(" "));
            int n = Integer.parseInt(list.get(0));
            int m = Integer.parseInt(list.get(1));
            if(m == n) {
                System.out.println(1);
            }else if(n == 1) {
                System.out.println(m);
            }else{
                System.out.println(calComb(m, n));
            }
        }
    }
    public static BigInteger calComb(int m, int n){
        /* 공식 m!/(m-n)!*n! */
        return calFact(m).divide(calFact(m-n).multiply(calFact(n)));
    }
    public static BigInteger calFact(int i){
        BigInteger result = BigInteger.ONE;
        for (int j= 1; j <= i; j++){
            result = result.multiply(BigInteger.valueOf(j));
        }
        return result;
    }
}



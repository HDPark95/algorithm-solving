
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            if(input == calcConstructor(i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    public static int calcConstructor(int i){
        String strI = String.valueOf(i);
        int result = i;
        for (int j = 0; j < strI.length(); j++) {
            char n = strI.charAt(j);
            result += Character.getNumericValue(n);
        }
        return result;
    }
}

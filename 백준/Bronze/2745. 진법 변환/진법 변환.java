
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArray = input.split(" ");
        String n = strArray[0];
        int b = Integer.parseInt(strArray[1]);
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int num = 0;
            if(c >= '0' && c <= '9'){
                num = c - '0';
            }else{
                num = c - 'A' + 10;
            }
            result = result * b + num;
        }
        System.out.println(result);
    }
}
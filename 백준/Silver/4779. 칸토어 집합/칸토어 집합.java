
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.next());
            int pow = (int) Math.pow(3, n);
            String input = "-".repeat(pow);
            String result = solution(input);
            System.out.println(result);
        }
    }
    public static String solution(String input){
        if(input.length() == 1){
            return input;
        }
        int length = input.length();
        int divide = length / 3;

        String start = solution(input.substring(0, divide));
        String middle = " ".repeat(divide);
        String end = solution(input.substring(divide*2));
        return start + middle + end;
    }
}
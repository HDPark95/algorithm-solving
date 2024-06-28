import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int i = 0;
        int count = 0;
        while(true){
            if(checkDommsDayNumber(count)){
                i ++;
                if(i == number){
                    System.out.println(count);
                    break;
                }
            }
            count++;
        }
    }

  public static boolean checkDommsDayNumber(int count){
        int count1 = 0;
        String strNumber = String.valueOf(count);
        return strNumber.contains("666") ? true : false;
    }

}
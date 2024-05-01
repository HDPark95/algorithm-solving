import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        for (int i = 0; i < num; i++) {
            String input = sc.next();
            String[] strArray = input.split("");
            Set<String> alreadyCheck = new HashSet<>();
            boolean isGroupAlpha = true;
            String beforeAlpha = "";
            for(int j = 0; j < strArray.length ; j ++){
                String current = strArray[j];
                if(alreadyCheck.contains(current) && !beforeAlpha.equals(current) ){
                    isGroupAlpha = false;
                }else{
                    beforeAlpha = current;
                    alreadyCheck.add(current);
                }
            }
            if(isGroupAlpha){
                //System.out.println(input);
                count++;
            }
        }
        System.out.println(count);
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        if(s.isEmpty()){
            System.out.println(0);
        } else {
            String[] words = s.split("\\s+");
            System.out.println(words.length);
        }
        sc.close();
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        Character[] digits = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i);
        }
        Arrays.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (char c : digits) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}

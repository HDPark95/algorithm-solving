
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);
        int e = Integer.parseInt(s[4]);
        int f = Integer.parseInt(s[5]);

        Formula formula1 = new Formula(a, b, c);
        Formula formula2 = new Formula(d, e, f);

        int[] solve = formula1.solve(formula2);
        System.out.println(solve[0] + " " + solve[1]);
    }

    public static class Formula {
        int a, b, c;

        public Formula(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int[] solve(Formula other) {
            int determinant = this.a * other.b - other.a * this.b;

            int xNumerator = this.c * other.b - other.c * this.b;
            int x = xNumerator / determinant;

            int yNumerator = this.a * other.c - other.a * this.c;
            int y = yNumerator / determinant;

            return new int[]{x, y};        }
    }
}

import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = Arrays.stream(arrayA).reduce((left, right) -> gcd(left, right)).orElse(0);
        int b = Arrays.stream(arrayB).reduce((left, right) -> gcd(left, right)).orElse(0);
        int length = arrayA.length;

        if(a != 1){
            for (int i = 0; i < length; i++) {
                if(arrayB[i] % a == 0){
                    a = 0;
                    break;
                }
            }
        }
        if(b != 1){
            for (int i = 0; i < length; i++) {
                if(arrayA[i] % b == 0){
                    b = 0;
                    break;
                }
            }
        }
        return Math.max(a, b) == 1 ? 0 : Math.max(a, b);
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
}
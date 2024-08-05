import java.util.HashSet;
import java.util.Set;

class Solution {
    int N;
    Set<Integer> primeList;
    String numbers1;
    boolean[] visited;
    
    public int solution(String numbers) {
        N = numbers.length();
        primeList = new HashSet<>();
        numbers1 = numbers;
        visited = new boolean[N+1];
        recursive(0, "");
        return primeList.size();
    }
    
    private void recursive(int size, String s){
        if(size > N){
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                String number = s + numbers1.charAt(i);
                int intNumber = Integer.parseInt(number);
                if(isPrime(intNumber)){
                    primeList.add(intNumber);
                }
                recursive(size+1, number);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number){
        if(number < 2){
            return false;
        }
        for (int i = 2; i <number; i++) {
            if (number % i == 0 ){
                return false;
            }
        }
        return true;
    }
    
}
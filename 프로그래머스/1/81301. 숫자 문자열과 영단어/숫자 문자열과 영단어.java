import java.util.List;

class Solution {
    
    public int solution(String s) {
        List<String> words = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for(int i = 0; i < words.size(); i++){
            s = s.replaceAll(words.get(i), String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
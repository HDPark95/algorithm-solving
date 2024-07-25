import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2; i++) {  //절반넘어가면 할 필요없음 못줄임.
            String compressedWord = compress(s, i);
            answer = Math.min(answer, compressedWord.length());
        }
        return answer;
    }
    
    public String compress(String s, int length){
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i += length) {
            queue.add(s.substring(i, Math.min(i + length, s.length())));
        }

        String prev = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(prev)) {
                count++;
            } else {
                appendString(sb, count, prev);
                prev = current;
                count = 1;
            }
        }
        appendString(sb, count, prev);
        
        return sb.toString();
    }
    
    public void appendString(StringBuilder sb, int count, String prev){
        if (count > 1) {
            sb.append(count).append(prev);
        } else {
            sb.append(prev);
        }
    }
}
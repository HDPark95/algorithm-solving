import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words 배열에 없는 경우 변환할 수 없으므로 0을 반환
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(begin, 0));
        
        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            String currentWord = node.word;
            int count = node.count;
            
            // 현재 단어가 타겟 단어와 일치하면 변환 횟수를 반환
            if (currentWord.equals(target)) {
                return count;
            }
            
            // 현재 단어와 한 글자만 다른 단어를 찾아 큐에 추가
            for (String word : words) {
                if (canTransform(currentWord, word)) {
                    queue.add(new WordNode(word, count + 1));
                }
            }
        }
        
        // 타겟 단어로 변환할 수 없는 경우
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 메소드
    private boolean canTransform(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
    
    // 변환 단어와 그때의 변환 횟수를 저장하는 클래스
    private class WordNode {
        String word;
        int count;
        
        WordNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}

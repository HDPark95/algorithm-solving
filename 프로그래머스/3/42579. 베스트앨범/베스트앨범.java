import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<Integer[]>> playMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

            if (!playMap.containsKey(genres[i])) {
                playMap.put(genres[i], new ArrayList<>());
            }
            playMap.get(genres[i]).add(new Integer[]{i, plays[i]});
        }

        genreMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    List<Integer[]> songs = playMap.get(entry.getKey());
                    songs.sort((a, b) -> b[1] - a[1]);
                    
                    for (int i = 0; i < Math.min(2, songs.size()); i++) {
                        answer.add(songs.get(i)[0]);
                    }
                });
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
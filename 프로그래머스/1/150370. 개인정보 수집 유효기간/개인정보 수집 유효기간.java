import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        HashMap<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] termsArray = terms[i].split(" ");
            termsMap.put(termsArray[0], Integer.parseInt(termsArray[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArray = privacies[i].split(" ");
            String termsName = privacyArray[1];
            int termsPeriod = termsMap.get(termsName);
            LocalDate privacyDate = LocalDate.parse(privacyArray[0], formatter);
            //말소일
            LocalDate deleteDate = privacyDate.plusMonths(termsPeriod);
            System.out.println(deleteDate + " " + todayDate);
            System.out.println(deleteDate.isBefore(todayDate));
            if (deleteDate.isBefore(todayDate) || deleteDate.isEqual(todayDate)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        Arrays.sort(strNumbers, (x, y) -> (y + x).compareTo(x + y));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }

        return sb.toString();
    }
}
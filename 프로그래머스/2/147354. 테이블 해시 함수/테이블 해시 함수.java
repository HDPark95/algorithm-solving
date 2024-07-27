import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        int colIndex = col - 1;

        int[][] sorted = Arrays.stream(data).sorted(
                        (a, b) -> {
                            if(a[colIndex] == b[colIndex]) {
                                return b[0] - a[0]; //오름차순
                            } else {
                                return a[colIndex] - b[colIndex]; //내림차순
                            }
                        })
                .toArray(int[][]::new);

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int cumSum = 0;
            for (int j = 0; j < sorted[i].length; j++) {
                cumSum += sorted[i][j] % (i + 1);
            }
            answer ^= cumSum;
        }
        return answer;
    }
}
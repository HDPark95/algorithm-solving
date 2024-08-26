import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static char[][] map;
    static boolean[] visitedRow;
    static boolean[] visitedCol;
    static int minScore = Integer.MAX_VALUE;
    static int maxScore = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visitedRow = new boolean[N];
        visitedCol = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        List<int[]> selected = new ArrayList<>();
        solution(0, selected);

        System.out.println(minScore);
        System.out.println(maxScore);
    }

    private static void solution(int i, List<int[]> selected) {
        if (i == N) {
            int score = calculateScore(selected);
            int cycle = checkCycle(selected);
 
            if (cycle % 2 == 0) {
                score *= -1;
            }
            minScore = Math.min(minScore, score);
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visitedRow[i] && !visitedCol[j]) {
                visitedRow[i] = true;
                visitedCol[j] = true;
                selected.add(new int[]{i, j});
                solution(i + 1, selected);
                selected.remove(selected.size() - 1);
                visitedRow[i] = false;
                visitedCol[j] = false;
            }
        }
    }
    /*
    *   'A': 65
        'B': 66
        'C': 67
        'D': 68
        'E': 69
        'F': 70
        'G': 71
        'H': 72
        'I': 73
    * */
    private static int calculateScore(List<int[]> selected) {
        int score = 1;
        for (int[] pos : selected) {
            int row = pos[0];
            int col = pos[1];
            char value = map[row][col];

            if (Character.isDigit(value)) {
                score *= Character.getNumericValue(value);
            } else if (value >= 'A' && value <= 'I') {
                score *= -(value - 'A' + 1);
            }
        }
        return score;
    }
    //사이클이 몇갠지 체크
    private static int checkCycle(List<int[]> selected) {
        int cnt = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                cnt++;
                visited[i] = true;
            }
            int col = selected.get(i)[1];
            while(!visited[col]){
                visited[col] = true;
                col = selected.get(col)[1];
            }
        }
        return cnt;
    }
}
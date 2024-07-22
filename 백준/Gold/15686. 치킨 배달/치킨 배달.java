
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Point> chickens;
    static List<Point> homes;
    static boolean[] selected;
    static int minTotalDistance = Integer.MAX_VALUE;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int target = Integer.parseInt(st.nextToken());
                if (target == 1) {
                    homes.add(new Point(i, j));
                } else if (target == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        selected = new boolean[chickens.size()];
        backtrack(0, 0);

        System.out.println(minTotalDistance);
    }

    public static void backtrack(int index, int count) {
        if (count == M) {
            calculateTotalDistance();
            return;
        }

        if (index == chickens.size()) {
            return;
        }

        // 현재 치킨집 선택
        selected[index] = true;
        backtrack(index + 1, count + 1);

        // 현재 치킨집 선택하지 않음
        selected[index] = false;
        backtrack(index + 1, count);
    }

    public static void calculateTotalDistance() {
        int totalDistance = 0;
        for (Point home : homes) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    int distance = Math.abs(home.r - chicken.r) + Math.abs(home.c - chicken.c);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            totalDistance += minDistance;
        }
        minTotalDistance = Math.min(minTotalDistance, totalDistance);
    }
}
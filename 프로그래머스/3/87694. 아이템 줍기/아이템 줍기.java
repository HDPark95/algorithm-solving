import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static boolean[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new boolean[101][101]; // 2배로 확대된 보드를 위한 배열 크기
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int i = 0; i < rectangle.length; i++) {
            int[] rect = rectangle[i];
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 경계선 설정
            for (int x = x1; x <= x2; x++) {
                board[x][y1] = true;
                board[x][y2] = true;
            }
            for (int y = y1; y <= y2; y++) {
                board[x1][y] = true;
                board[x2][y] = true;
            }
        }

        // 내부를 제거하여 경계선만 남김
        for (int i = 0; i < rectangle.length; i++) {
            int[] rect = rectangle[i];
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    board[x][y] = false;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});

        board[characterX][characterY] = false;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int distance = now[2];
            if (now[0] == itemX && now[1] == itemY) {
                return distance / 2;
            }
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x < 0 || y < 0 || x >= 101 || y >= 101) continue;

                if (board[x][y]) {
                    board[x][y] = false;
                    queue.add(new int[]{x, y, distance + 1});
                }
            }
        }

        return -1;
    }
}
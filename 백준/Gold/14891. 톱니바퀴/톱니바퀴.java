import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Cogwheel> inputs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            int[] status = new int[8];
            for (int j = 0; j < 8; j++) {
                status[j] = s.charAt(j) - '0';
            }
            inputs.add(new Cogwheel(i, status));
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] command = br.readLine().split(" ");
            int index = Integer.parseInt(command[0]) - 1;
            int direction = Integer.parseInt(command[1]);
            move(inputs, index, direction);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (inputs.get(i).status[0] == 1) {
                score += (1 << i);
            }
        }
        System.out.println(score);
    }

    public static class Cogwheel {
        int index;
        int[] status;

        public Cogwheel(int index, int[] status) {
            this.index = index;
            this.status = status;
        }

        public void rotate(int direction) {
            if (direction == 1) { // 시계 방향 회전
                int temp = status[7];
                System.arraycopy(status, 0, status, 1, 7);
                status[0] = temp;
            } else if (direction == -1) { // 반시계 방향 회전
                int temp = status[0];
                System.arraycopy(status, 1, status, 0, 7);
                status[7] = temp;
            }
        }
    }

    public static void move(List<Cogwheel> cogwheels, int index, int direction) {
        boolean[] toRotate = new boolean[4];
        int[] directions = new int[4];

        toRotate[index] = true;
        directions[index] = direction;

        // 왼쪽 톱니바퀴 체크
        for (int i = index - 1; i >= 0; i--) {
            if (cogwheels.get(i + 1).status[6] != cogwheels.get(i).status[2]) {
                toRotate[i] = true;
                directions[i] = -directions[i + 1];
            } else {
                break;
            }
        }

        // 오른쪽 톱니바퀴 체크
        for (int i = index + 1; i < 4; i++) {
            if (cogwheels.get(i - 1).status[2] != cogwheels.get(i).status[6]) {
                toRotate[i] = true;
                directions[i] = -directions[i - 1];
            } else {
                break;
            }
        }

        // 회전 수행
        for (int i = 0; i < 4; i++) {
            if (toRotate[i]) {
                cogwheels.get(i).rotate(directions[i]);
            }
        }
    }
}

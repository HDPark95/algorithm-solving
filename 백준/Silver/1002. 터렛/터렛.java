import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();
            System.out.println(solution(x1, y1, r1, x2, y2, r2));
        }
    }
    public static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); //두 사람 사이의 거리
        int sum = (int) (Math.pow(r1 + r2, 2)); //더하기
        int sub = (int) (Math.pow(r1 - r2, 2)); //빼기
        if (distance == 0) { //두 사람이 같은 위치에 있을 때
            if (r1 == r2) { //반지름이 같을 때 무한대임
                return -1;
            } else { //반지름이 다를 때 만나지 않음
                return 0;
            }
        } else {
            if (distance == sum || distance == sub) { //두 원이 외접하거나 내접할 때
                return 1;
            } else if (distance < sum && distance > sub) { //두 원이 두 점에서 만날 때
                return 2;
            } else { //나머지는 만나지 않음
                return 0;
            }
        }
    }
}

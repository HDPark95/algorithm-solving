import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static Integer N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            Point point = new Point(x, y);
            queue.offer(point);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Point point = queue.poll();
            sb.append(point.getX()).append(" ").append(point.getY()).append("\n");
        }
        System.out.println(sb);
    }
    public static class Point implements Comparable<Point>{
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int compareX = o.getX();
            if (x > compareX){
                return 1;
            } else if (x == compareX) {
                int compareY = o.getY();
                if (y > compareY){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return  -1;
            }
        }
    }
}

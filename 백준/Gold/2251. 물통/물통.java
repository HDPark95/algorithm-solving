
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int A,B,C;
    static Set<Integer> answers = new HashSet<>();
    static List<int[]> visited = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        A = Integer.parseInt(inputs[0]);
        B = Integer.parseInt(inputs[1]);
        C = Integer.parseInt(inputs[2]);
        solution(0, 0, C);

        System.out.println(answers.stream().sorted().map(Object::toString).collect(Collectors.joining(" ")));
    }

    public static void solution(int a, int b, int c){
        for (int i = 0; i < visited.size(); i++) {
            int prevA = visited.get(i)[0];
            int prevB = visited.get(i)[1];
            int prevC = visited.get(i)[2];
            if (a == prevA && b == prevB && c == prevC) {
                return;
            }
        }
        visited.add(new int[]{a, b, c});

        if (a == 0){
            answers.add(c);
        }

        int moveAB = Math.min(a, B - b);
        solution(a - moveAB, b + moveAB, c);

        int moveAC = Math.min(a, C - c);
        solution(a - moveAC, b, c + moveAC);

        int moveBA = Math.min(b, A - a);
        solution(a + moveBA, b - moveBA, c);

        int moveBC = Math.min(b, C - c);
        solution(a, b - moveBC, c + moveBC);

        int moveCA = Math.min(c, A - a);
        solution(a + moveCA, b, c - moveCA);

        int moveCB = Math.min(c, B - b);
        solution(a, b + moveCB, c - moveCB);

    }
}